from django.shortcuts import render
import html
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
from .models import DecisionTable, Category,DecisionTable1
import json




def extract_dta_files(folder_path):
    decision_table_list = []

    # Fetch category
    action_rules_category = Category.objects.get(name='Decision Tables')

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.dta'):
                file_path = os.path.join(root, file)
                full_file_name = os.path.relpath(file_path, start=folder_path)

                tree = ET.parse(file_path)
                root_element = tree.getroot()

                tag_data = {}

                def extract_xml_data(element, data):
                    for child in element:
                        tag_name = child.tag.split('}')[-1]
                        if child.text:
                            tag_content = html.unescape(child.text.strip())
                        else:
                            tag_content = ''

                        # Check if the current tag is "Preconditions" and store its text separately
                        if tag_name == 'Preconditions':
                            preconditions_text = ""
                            for text_node in child.itertext():
                                preconditions_text += text_node.strip() + " "
                            #print("Preconditions Text:", preconditions_text.strip())
                            data['preconditions_text'] = preconditions_text.strip()
                        else:
                            data[tag_name] = tag_content

                        if len(list(child)) > 0:
                            data[tag_name] = {}
                            extract_xml_data(child, data[tag_name])

                extract_xml_data(root_element, tag_data)
                decision_table_list.append({'file_name': full_file_name, 'tag_data': tag_data, 'category': action_rules_category})

    return decision_table_list

@api_view(['POST'])
@csrf_exempt
def upload_workspace_DTA(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        # Ensure "Decision Tables" category exists
        action_rules_category, _ = Category.objects.get_or_create(name='Decision Tables')

        extracted_data_list = extract_dta_files(temp_dir)  

        for extracted_data in extracted_data_list:
            decision_table = DecisionTable1.create_from_tag_data(
                file_name=extracted_data['file_name'],
                tag_data=extracted_data['tag_data'],
                category=extracted_data['category'],
            )
        
        # Clean up temporary directory
        for item in os.listdir(temp_dir):
            item_path = os.path.join(temp_dir, item)
            if os.path.isfile(item_path):
                os.remove(item_path)
            else:
                shutil.rmtree(item_path)

        os.rmdir(temp_dir)

        return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': [{'file_name': data['file_name'], 'tag_data': data['tag_data'], 'category': data['category'].name} for data in extracted_data_list]})
    
    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})




'''def extract_dta_files(folder_path):
    decision_table_list = []

    # Fetch  category
    action_rules_category = Category.objects.get(name='Decision Tables')

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.dta'):
                file_path = os.path.join(root, file)
                full_file_name = os.path.relpath(file_path, start=folder_path)

                tree = ET.parse(file_path)
                root_element = tree.getroot()

                tag_data = {}

                def extract_xml_data(element, data):
                    for child in element:
                        tag_name = child.tag.split('}')[-1]
                        if child.text:
                            tag_content = html.unescape(child.text.strip())
                        else:
                            tag_content = ''

                        data[tag_name] = tag_content

                        if len(list(child)) > 0:
                            data[tag_name] = {}
                            extract_xml_data(child, data[tag_name])

                extract_xml_data(root_element, tag_data)

                decision_table_list.append({'file_name': full_file_name, 'tag_data': tag_data, 'category': action_rules_category})

    return decision_table_list'''


'''@api_view(['POST'])
def upload_workspace_DTA(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        # Ensure "Decision Tables" category exists
        action_rules_category, _ = Category.objects.get_or_create(name='Decision Tables')

        extracted_data_list = extract_dta_files(temp_dir)  

        for extracted_data in extracted_data_list:
            rule = DecisionTable.objects.create(
                file_name=extracted_data['file_name'],
                tag_data=extracted_data['tag_data'],
                category=extracted_data['category']
            )
        
        # Clean up temporary directory
        for item in os.listdir(temp_dir):
            item_path = os.path.join(temp_dir, item)
            if os.path.isfile(item_path):
                os.remove(item_path)
            else:
                shutil.rmtree(item_path)

        os.rmdir(temp_dir)

        return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': [{'file_name': data['file_name'], 'tag_data': data['tag_data'], 'category': data['category'].name} for data in extracted_data_list]})

    
    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})

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
    
    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})'''