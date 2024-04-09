from django.shortcuts import render
import os
import re
import zipfile
from django.http import JsonResponse
from rest_framework.decorators import api_view
from .models import ActionRules, DecisionTable
from rest_framework.decorators import api_view, permission_classes
import shutil

def extract_brl_files(folder_path):
    brl_data_dict = {}  # Dictionary to store extracted data

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.brl'):
                file_path = os.path.join(root, file)
                
                # Extracting the file name without extension
                file_name = os.path.splitext(file)[0]  
                
                # Include the parent directory in the file name if there are similar file names
                full_file_name = os.path.relpath(file_path, start=folder_path)
                
                with open(file_path, 'r', encoding='utf-8') as brl_file:
                    content = brl_file.read()
                    
                    # Look for <![CDATA[ tag content
                    cdata_content = re.findall(r'<!\[CDATA\[(.*?)\]\]>', content, re.DOTALL)
                    
                    for data in cdata_content:
                        if_part = re.search(r'\bif\b(.*?)\bthen\b', data, re.DOTALL)
                        then_part = re.search(r'\bthen\b(.*)', data, re.DOTALL)
                        
                        if if_part and then_part:
                            if_content = if_part.group(1).strip()
                            then_content = then_part.group(1).strip()
                            
                            key = full_file_name if full_file_name not in brl_data_dict else os.path.join(os.path.relpath(root, start=folder_path), full_file_name)
                            
                            if key in brl_data_dict:
                                brl_data_dict[key].append({'if': if_content, 'then': then_content})
                            else:
                                brl_data_dict[key] = [{'if': if_content, 'then': then_content}]
    
    return brl_data_dict



@api_view(['POST'])
def upload_workspace(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        brl_data_dict = extract_brl_files(temp_dir)  # Assuming extract_brl_files function is defined
        
        for file_name, content_list in brl_data_dict.items():
            for content_dict in content_list:
                extracted_action_rules = f"File: {file_name}\nIf: {content_dict['if']}\nThen: {content_dict['then']}"
                action_rule = ActionRules(extracted_action_rules=extracted_action_rules)
                action_rule.save()
        
        # Remove all files and subdirectories inside the temporary directory
        for item in os.listdir(temp_dir):
            item_path = os.path.join(temp_dir, item)
            if os.path.isfile(item_path):
                os.remove(item_path)
            else:
                shutil.rmtree(item_path)

        # Remove the temporary directory
        os.rmdir(temp_dir)

        return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': brl_data_dict})
    
    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})




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
