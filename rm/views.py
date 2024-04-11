import html
from django.shortcuts import render
import os
import re
import zipfile
from django.http import JsonResponse
from rm.serializers import CategorySerializer
from .models import ActionRule, ActionRules, Category, DecisionTable, DecisionTable1, ExtractedRule, Queries
from rest_framework.decorators import api_view, permission_classes
import shutil
import xml.etree.ElementTree as ET
import json
from rest_framework import status
from rest_framework.response import Response

# def extract_brl_files(folder_path):
#     brl_data_dict = {}  # Dictionary to store extracted data

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.brl'):
#                 file_path = os.path.join(root, file)
                
#                 # Extracting the file name without extension
#                 file_name = os.path.splitext(file)[0]  
                
#                 # Include the parent directory in the file name if there are similar file names
#                 full_file_name = os.path.relpath(file_path, start=folder_path)
                
#                 with open(file_path, 'r', encoding='utf-8') as brl_file:
#                     content = brl_file.read()
                    
#                     # Look for <definition> tag content
#                     definition_content = re.findall(r'<definition>(.*?)</definition>', content, re.DOTALL)
                    
#                     for definition_data in definition_content:
#                         key = full_file_name if full_file_name not in brl_data_dict else os.path.join(os.path.relpath(root, start=folder_path), full_file_name)
                        
#                         if key in brl_data_dict:
#                             brl_data_dict[key].append({'definition': definition_data})
#                         else:
#                             brl_data_dict[key] = [{'definition': definition_data}]
    
#     return brl_data_dict



# @api_view(['POST'])
# def upload_workspace(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         brl_data_dict = extract_brl_files(temp_dir)  
        
#         for file_name, content_list in brl_data_dict.items():
#             for content_dict in content_list:
#                 extracted_action_rules = content_dict['definition']
#                 action_rule = ActionRules(extracted_action_rules=extracted_action_rules)
#                 action_rule.save()
        
#         # Remove all files and subdirectories inside the temporary directory
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         # Remove the temporary directory
#         os.rmdir(temp_dir)

#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': brl_data_dict})
    
#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})





# def extract_dta_files(folder_path):
#     preconditions_data_dict = {}  # Dictionary to store extracted precondition data

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.dta'):
#                 file_path = os.path.join(root, file)
                
#                 # Extracting the file name without extension
#                 file_name = os.path.splitext(file)[0]  
                
#                 # Include the parent directory in the file name if there are similar file names
#                 full_file_name = os.path.relpath(file_path, start=folder_path)
                
#                 with open(file_path, 'r', encoding='utf-8') as dta_file:
#                     content = dta_file.read()
                    
#                     # Look for <Preconditions> tag content without <Text> and <![CDATA[ tags
#                     preconditions_content = re.findall(r'<Preconditions>(.*?)</Preconditions>', content, re.DOTALL)
                    
#                     for data in preconditions_content:
#                         key = full_file_name if full_file_name not in preconditions_data_dict else os.path.join(os.path.relpath(root, start=folder_path), full_file_name)
                        
#                         if key in preconditions_data_dict:
#                             preconditions_data_dict[key].append({'precondition': data})
#                         else:
#                             preconditions_data_dict[key] = [{'precondition': data}]
    
#     return preconditions_data_dict


# @api_view(['POST'])
# def upload_workspace_DTA(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         dta_data_dict = extract_dta_files(temp_dir)  # Assuming extract_dta_files function is defined
        
#         for file_name, content_list in dta_data_dict.items():
#             for content_dict in content_list:
#                 extracted_decision_table = f"File: {file_name}\nPrecondition: {content_dict['precondition']}"
#                 decision_table = DecisionTable(extracted_decision_table=extracted_decision_table)
#                 decision_table.save()
        
#         # Remove all files and subdirectories inside the temporary directory
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         # Remove the temporary directory
#         os.rmdir(temp_dir)

#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'dta_data': dta_data_dict})
    
#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})





# Function to extract data from XML files with a ".brl" extension
# @api_view(['POST'])
# def upload_workspace(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         brl_data_list = extract_brl_files(temp_dir)  
        
#         for data_dict in brl_data_list:
#              rule = ExtractedRule.objects.create(
#                 file_name=data_dict['file_name'],
#                 tag_data=data_dict['tag_data']
#             )
           
        
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         os.rmdir(temp_dir)


#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': brl_data_list})
    
#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})


# test function to extract the data from the xml file as .brl file


# def extract_brl_files(folder_path):
#     brl_data_list = []  

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.brl'):
#                 file_path = os.path.join(root, file)
#                 full_file_name = os.path.relpath(file_path, start=folder_path)

#                 tree = ET.parse(file_path)
#                 root_element = tree.getroot()

#                 tag_data = {}
                
#                 for child in root_element.iter():
#                     tag_name = child.tag.split('}')[-1]  # Extracting tag name without namespace
#                     if child.text:
#                         tag_content = html.unescape(child.text.strip())  # Decode HTML entities
#                     else:
#                         tag_content = ''
#                     tag_data[tag_name] = tag_content

#                 data_dict = {'file_name': full_file_name, 'tag_data': tag_data}
#                 brl_data_list.append(data_dict)
    
#     return brl_data_list



# Function to extract data from XML files with a ".brl" extension
# this function is to extract the data from the xml file as .brl file action rules
# def extract_brl_files(folder_path):
#     brl_data_list = []  

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.brl'):
#                 file_path = os.path.join(root, file)
#                 full_file_name = os.path.relpath(file_path, start=folder_path)

#                 tree = ET.parse(file_path)
#                 root_element = tree.getroot()

#                 tag_data = {}

#                 # Function to recursively extract data from XML elements
#                 def extract_xml_data(element, data):
#                     for child in element:
#                         tag_name = child.tag.split('}')[-1]
#                         if child.text:
#                             tag_content = html.unescape(child.text.strip())
#                         else:
#                             tag_content = ''

#                         data[tag_name] = tag_content

#                         if len(list(child)) > 0:
#                             data[tag_name] = {}
#                             extract_xml_data(child, data[tag_name])

#                 # Extracting data from the root element
#                 extract_xml_data(root_element, tag_data)

#                 data_dict = {'file_name': full_file_name, 'tag_data': tag_data}
#                 brl_data_list.append(data_dict)
    
#     return brl_data_list


# Function to extract data from XML files with a ".dta" extension
# this function is to extract the data from the xml file as .brl file decision tables
# def extract_dta_files(folder_path):
#     querie_data_list = []  

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.dta'):
#                 file_path = os.path.join(root, file)
#                 full_file_name = os.path.relpath(file_path, start=folder_path)

#                 tree = ET.parse(file_path)
#                 root_element = tree.getroot()

#                 tag_data = {}

#                 # Function to recursively extract data from XML elements
#                 def extract_xml_data(element, data):
#                     for child in element:
#                         tag_name = child.tag.split('}')[-1]
#                         if child.text:
#                             tag_content = html.unescape(child.text.strip())
#                         else:
#                             tag_content = ''

#                         data[tag_name] = tag_content

#                         if len(list(child)) > 0:
#                             data[tag_name] = {}
#                             extract_xml_data(child, data[tag_name])

#                 # Extracting data from the root element
#                 extract_xml_data(root_element, tag_data)

#                 data_dict = {'file_name': full_file_name, 'tag_data': tag_data}
#                 querie_data_list.append(data_dict)
    
#     return querie_data_list


# # Function to extract data from XML files with a ".dta" extension
# @api_view(['POST'])
# def upload_workspace_DTA(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         querie_data_list = extract_dta_files(temp_dir)  
        
#         for data_dict in querie_data_list:
#              rule = DecisionTable1.objects.create(
#                 file_name=data_dict['file_name'],
#                 tag_data=data_dict['tag_data']
#             )
           
        
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         os.rmdir(temp_dir)


#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': querie_data_list})
    
#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})


# # Function to extract data from XML files with a ".qry" extension
# # this function is to extract the data from the xml file as .brl file queries
# def extract_qry_files(folder_path):
#     qry_data_list = []  

#     for root, dirs, files in os.walk(folder_path):
#         for file in files:
#             if file.endswith('.qry'):
#                 file_path = os.path.join(root, file)
#                 full_file_name = os.path.relpath(file_path, start=folder_path)

#                 tag_data = {}

#                 # Function to recursively extract data from XML elements
#                 def extract_xml_data(element, data):
#                     for child in element:
#                         tag_name = child.tag.split('}')[-1]
#                         if child.text:
#                             tag_content = html.unescape(child.text.strip())
#                         else:
#                             tag_content = ''

#                         data[tag_name] = tag_content

#                         if len(list(child)) > 0:
#                             data[tag_name] = {}
#                             extract_xml_data(child, data[tag_name])

#                 try:
#                     tree = ET.parse(file_path)
#                     root_element = tree.getroot()
#                     # Extracting data from the root element
#                     extract_xml_data(root_element, tag_data)

#                     data_dict = {'file_name': full_file_name, 'tag_data': tag_data}
#                     qry_data_list.append(data_dict)
#                 except Exception as e:
#                     print(f"Error processing file {file_path}: {e}")

#     return qry_data_list

# Function to upload and extract queries from a zip file containing XML files with a ".qry" extension
# @api_view(['POST'])
# def upload_workspace_Queries(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         querie_data_list = extract_qry_files(temp_dir)  
        
#         for data_dict in querie_data_list:
#              querie = Queries.objects.create(
#                 file_name=data_dict['file_name'],
#                 tag_data=data_dict['tag_data']
#             )
           
        
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         os.rmdir(temp_dir)


#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': querie_data_list})
    
#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})




def extract_brl_files(folder_path):
    action_rule_list = []

    # Fetch the "Action Rules" category
    action_rules_category = Category.objects.get(name='Action Rules')

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.brl'):
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

                action_rule_list.append({'file_name': full_file_name, 'tag_data': tag_data, 'category': action_rules_category})

    return action_rule_list

@api_view(['POST'])
def upload_workspace(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        extracted_data_list = extract_brl_files(temp_dir)  

        for extracted_data in extracted_data_list:
            rule = ActionRule.objects.create(
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





def extract_dta_files(folder_path):
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

    return decision_table_list

@api_view(['POST'])
def upload_workspace_DTA(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        extracted_data_list = extract_dta_files(temp_dir)  

        for extracted_data in extracted_data_list:
            rule = DecisionTable1.objects.create(
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



def extract_queries_files(folder_path):
    queries_list = []

    # Fetch  category
    action_rules_category = Category.objects.get(name='Queries')

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.qry'):
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

                queries_list.append({'file_name': full_file_name, 'tag_data': tag_data, 'category': action_rules_category})

    return queries_list


@api_view(['POST'])
def upload_workspace_Queries(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        extracted_data_list = extract_queries_files(temp_dir)  

        for extracted_data in extracted_data_list:
            rule = Queries.objects.create(
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




@api_view(['POST'])
def create_category(request):
    if request.method == 'POST':
        serializer = CategorySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)