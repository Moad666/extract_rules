from django.shortcuts import render

import xml.etree.ElementTree as ET
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
import zipfile
import os 
import shutil
import tempfile
import fnmatch
from rest_framework.decorators import api_view
from django.shortcuts import render
import re
from .models import DecisionTable


def extract_dta_files(folder_path):
    preconditions_data_dict = {}  # Dictionary to store extracted precondition data

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.dta'):
                file_path = os.path.join(root, file)
                
                # Extracting the file name without extension
                file_name = os.path.splitext(file)[0]  
                
                # Include the parent directory in the file name if there are similar file names
                full_file_name = os.path.relpath(file_path, start=folder_path)
                
                with open(file_path, 'r', encoding='utf-8') as dta_file:
                    content = dta_file.read()
                    
                    # Look for <Preconditions> tag content without <Text> and <![CDATA[ tags
                    preconditions_content = re.findall(r'<Preconditions>(.*?)</Preconditions>', content, re.DOTALL)
                    
                    for data in preconditions_content:
                        key = full_file_name if full_file_name not in preconditions_data_dict else os.path.join(os.path.relpath(root, start=folder_path), full_file_name)
                        
                        if key in preconditions_data_dict:
                            preconditions_data_dict[key].append({'precondition': data})
                        else:
                            preconditions_data_dict[key] = [{'precondition': data}]
    
    return preconditions_data_dict


@api_view(['POST'])
def upload_workspace_DTA(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        dta_data_dict = extract_dta_files(temp_dir)  # Assuming extract_dta_files function is defined
        
        for file_name, content_list in dta_data_dict.items():
            for content_dict in content_list:
                extracted_decision_table = f"File: {file_name}\nPrecondition: {content_dict['precondition']}"
                decision_table = DecisionTable(extracted_decision_table=extracted_decision_table)
                decision_table.save()
        
        # Remove all files and subdirectories inside the temporary directory
        for item in os.listdir(temp_dir):
            item_path = os.path.join(temp_dir, item)
            if os.path.isfile(item_path):
                os.remove(item_path)
            else:
                shutil.rmtree(item_path)

        # Remove the temporary directory
        os.rmdir(temp_dir)

        return JsonResponse({'message': 'Files extracted and saved successfully.', 'dta_data': dta_data_dict})
    
    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})

# extract one file preconditions
'''@csrf_exempt
def extract_data(request):
    if request.method == 'POST' and request.FILES.get('file'):
        try:
            # Get the uploaded file
            uploaded_file = request.FILES['file']
            
            # Check if the file is a zip file
            if uploaded_file.name.endswith('.zip'):
                # Create a temporary directory to extract the zip contents
                temp_dir = 'temp_extracted_files'
                os.makedirs(temp_dir, exist_ok=True)
                
                # Extract the zip file contents
                with zipfile.ZipFile(uploaded_file, 'r') as zip_ref:
                    zip_ref.extractall(temp_dir)
                
                # Find the .dta file within the extracted files
                dta_file_path = None
                for root, dirs, files in os.walk(temp_dir):
                    for filename in files:
                        if filename.endswith('.dta'):
                            dta_file_path = os.path.join(root, filename)
                            break
                    if dta_file_path:   
                        break

                if dta_file_path: 
                    # Parse the .dta data
                    tree = ET.parse(dta_file_path)
                    root = tree.getroot()
                    
                    # Find the Preconditions tag within the Body section
                    body = root.find('.//{http://schemas.ilog.com/Rules/7.0/DecisionTable}Body')
                    if body is not None:
                        preconditions = body.find('{http://schemas.ilog.com/Rules/7.0/DecisionTable}Preconditions')
                        if preconditions is not None:
                            # Extract the CDATA text content inside Preconditions
                            preconditions_text = preconditions.find('{http://schemas.ilog.com/Rules/7.0/DecisionTable}Text').text.strip()
                            return JsonResponse({'preconditions': preconditions_text})
                        else:
                            return JsonResponse({'error': 'Preconditions tag not found'}, status=400)
                    else:
                        return JsonResponse({'error': 'Body section not found'}, status=400)
                else:
                    return JsonResponse({'error': 'No .dta file found in the zip folder'}, status=400)
            else:
                return JsonResponse({'error': 'Please upload a zip file'}, status=400)
        except Exception as e:
            return JsonResponse({'error': str(e)}, status=500)
        finally:
            # Clean up: Remove the temporary directory and its contents
            if os.path.exists(temp_dir):
                shutil.rmtree(temp_dir)
    else:
        return JsonResponse({'error': 'No file uploaded'}, status=400)'''



# extract all informations from .dta
'''@csrf_exempt
def extract_data(request):
    if request.method == 'POST' and request.FILES.get('file'):
        try:
            # Get the uploaded file
            uploaded_file = request.FILES['file']
            
            # Check if the file is a zip file
            if uploaded_file.name.endswith('.zip'):
                # Create a temporary directory to extract the zip contents
                temp_dir = 'temp_extracted_files'
                os.makedirs(temp_dir, exist_ok=True)
                
                # Extract the zip file contents
                with zipfile.ZipFile(uploaded_file, 'r') as zip_ref:
                    zip_ref.extractall(temp_dir)
                
                # Initialize dictionary to store .dta file content
                dta_files_content = {}
                
                # Find the .dta files within the extracted files
                for root, dirs, files in os.walk(temp_dir):
                    for filename in files:
                        if fnmatch.fnmatch(filename, '*.dta'):
                            dta_file_path = os.path.join(root, filename)
                            # Parse the .dta data
                            with open(dta_file_path, 'r') as dta_file:
                                # Process the .dta file content
                                dta_content = dta_file.read()
                            # Add content to the dictionary with the filename as key
                            dta_files_content[filename] = dta_content
                
                if dta_files_content: 
                    # Return the extracted data
                    return JsonResponse(dta_files_content)
                else:
                    return JsonResponse({'error': 'No .dta files found in the zip folder'}, status=400)
            else:
                return JsonResponse({'error': 'Please upload a zip file'}, status=400)
        except Exception as e:
            return JsonResponse({'error': str(e)}, status=500)
        finally:
            # Clean up: Remove the temporary directory and its contents
            if os.path.exists(temp_dir):
                shutil.rmtree(temp_dir)
    else:
        return JsonResponse({'error': 'No file uploaded'}, status=400)
'''
