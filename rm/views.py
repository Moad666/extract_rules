import html
from django.shortcuts import render
import os
import re
import zipfile
from django.http import JsonResponse
from rm.serializers import RuleCategorySerializer
from .models import ActionRule, DecisionTable, DecisionTable1, DecisionTable3, DecisionTable4, Queries, RuleCategory, DecisionTable5
from rest_framework.decorators import api_view, permission_classes
import shutil
import xml.etree.ElementTree as ET
import json
from rest_framework import status
from rest_framework.response import Response
from django.forms.models import model_to_dict

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


# def extract_brl_files(folder_path):
#     grouped_data = {}
#     action_rules_category = Category.objects.get(name='Action Rules')

#     for root, dirs, files in os.walk(folder_path):
#         parent_folder = os.path.basename(root)
#         if parent_folder not in grouped_data:
#             grouped_data[parent_folder] = []

#         for file in files:
#             if file.endswith('.brl'):
#                 file_path = os.path.join(root, file)
#                 full_file_name = os.path.relpath(file_path, start=folder_path)

#                 tree = ET.parse(file_path)
#                 root_element = tree.getroot()

#                 tag_data = {}

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

#                 extract_xml_data(root_element, tag_data)

#                 grouped_data[parent_folder].append({'file_name': full_file_name, 'tag_data': tag_data, 'category': action_rules_category, 'parent_folder': parent_folder})

#     return grouped_data



# @api_view(['POST'])
# def upload_workspace(request):
#     if request.method == 'POST' and request.FILES.get('zip_file'):
#         zip_file = request.FILES['zip_file']
        
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)
        
#         with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#             zip_ref.extractall(temp_dir)
        
#         extracted_data_dict = extract_brl_files(temp_dir)  

#         for parent_folder, extracted_data_list in extracted_data_dict.items():
#             for extracted_data in extracted_data_list:
#                 rule = ActionRule1.objects.create(
#                     file_name=extracted_data['file_name'],
#                     tag_data=extracted_data['tag_data'],
#                     category=extracted_data['category'],
#                     parent_folder=extracted_data['parent_folder']
#                 )
        
#         # Clean up temporary directory
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         os.rmdir(temp_dir)

#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': [{'parent_folder': data['parent_folder'], 'file_name': data['file_name'], 'tag_data': data['tag_data'], 'category': data['category'].name} for folder, data_list in extracted_data_dict.items() for data in data_list]})

#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})




def extract_brl_files(folder_path):
    extracted_data = []
    action_rules_category = RuleCategory.objects.get(name='Action Rules')
    for root, dirs, files in os.walk(folder_path):
        parent_folder = os.path.basename(root)

        for file in files:
            if file.endswith('.brl'):
                file_path = os.path.join(root, file)
                full_file_name = os.path.relpath(file_path, start=folder_path)

                tree = ET.parse(file_path)
                root_element = tree.getroot()

                extracted_values = {}
                for child in root_element:
                    tag_name = child.tag.split('}')[-1]
                    if child.text:
                        tag_content = html.unescape(child.text.strip())
                    else:
                        tag_content = ''

                    extracted_values[tag_name] = tag_content

                extracted_data.append({
                    'file_name': full_file_name,
                    'parent_folder': parent_folder,
                    'name': extracted_values.get('name', ''),
                    'uuid': extracted_values.get('uuid', ''),
                    'locale': extracted_values.get('locale', ''),
                    'definition': extracted_values.get('definition', ''),
                    'rule_category': action_rules_category
                })

    return extracted_data

@api_view(['POST'])
def upload_workspace(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        extracted_data_list = extract_brl_files(temp_dir)  
 
       
        
        for data in extracted_data_list:
            rule = ActionRule.objects.create(
                file_name=data['file_name'],
                parent_folder=data['parent_folder'],
                name=data['name'],
                uuid=data['uuid'],
                locale=data['locale'],
                definition=data['definition'],
                rule_category=data['rule_category']
            )
        
        # Clean up temporary directory
        shutil.rmtree(temp_dir)
 # Serialize the extracted data list for JSON response
        serialized_data = []
        for item in extracted_data_list:
            serialized_item = {
                'file_name': item['file_name'],
                'parent_folder': item['parent_folder'],
                'name': item['name'],
                'uuid': item['uuid'],
                'locale': item['locale'],
                'definition': item['definition'],
                'rule_category': item['rule_category'].name  # Assuming you want to include the category name
            }
            serialized_data.append(serialized_item)
        return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': serialized_data})

    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})


def extract_dta_files(folder_path):
    decision_table_list = []
    decision_tables_category = RuleCategory.objects.get(name='Decision Tables')

    for root, dirs, files in os.walk(folder_path):
        for file in files:
            if file.endswith('.dta'):
                file_path = os.path.join(root, file)
                full_file_name = os.path.relpath(file_path, start=folder_path)
                parent_folder = os.path.basename(root)

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

                # Update to include 'eAnnotations', 'name', 'uuid', and 'locale' attributes
                additional_attributes = {
                    'eAnnotations': tag_data.get('eAnnotations', ''),
                    'name': tag_data.get('name', ''),
                    'uuid': tag_data.get('uuid', ''),
                    'locale': tag_data.get('locale', '')
                }

                # Update to include only the 'definition' attribute
                definition_attribute = {'definition': tag_data.get('definition', {})} 

                decision_table_list.append({'file_name': full_file_name, 'rule_category': decision_tables_category, 'parent_folder': parent_folder, **definition_attribute, **additional_attributes})

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
        saved_instances = []  

        processed_data_list = []
        for data in extracted_data_list:
            file_name = data.get('file_name', '')  # Get file_name or set to empty string if not present
            eAnnotations = data.get('eAnnotations', '')
            name = data.get('name', '')
            uuid = data.get('uuid', '')
            locale = data.get('locale', '')

            rule_category_name = data['rule_category'].name if 'rule_category' in data else ''
            definition = data.get('definition', '')
              # Create a new DecisionTable instance and save it to the database
            decision_table_instance = DecisionTable(
                file_name=file_name,
                eAnnotations=eAnnotations,
                name=name,
                uuid=uuid,
                locale=locale,
                rule_category=RuleCategory.objects.get(name=rule_category_name),
                definition=definition,
                parent_folder=data.get('parent_folder', '')
            )
            decision_table_instance.save()
            saved_instances.append(model_to_dict(decision_table_instance))
            # Clean up temporary directory
        shutil.rmtree(temp_dir)
            # processed_data_list.append({'parent_folder': data.get('parent_folder', ''), 'file_name': file_name, 'rule_category': rule_category_name, 'definition': definition, 'eAnnotations': eAnnotations, 'name': name, 'uuid': uuid, 'locale': locale})

        return JsonResponse({'message': 'Files extracted and saved successfully.', 'dta_data': saved_instances})

    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})





def extract_queries_files(folder_path):
    extracted_data = []

    # Fetch  category
    querie_rules_category = RuleCategory.objects.get(name='Queries')

    for root, dirs, files in os.walk(folder_path):
        parent_folder = os.path.basename(root)

        for file in files:
            if file.endswith('.qry'):
                file_path = os.path.join(root, file)
                full_file_name = os.path.relpath(file_path, start=folder_path)

                tree = ET.parse(file_path)
                root_element = tree.getroot()

                extracted_values = {}
                for child in root_element:
                    tag_name = child.tag.split('}')[-1]
                    if child.text:
                        tag_content = html.unescape(child.text.strip())
                    else:
                        tag_content = ''

                    extracted_values[tag_name] = tag_content

                extracted_data.append({
                    'file_name': full_file_name,
                    'parent_folder': parent_folder,
                    'name': extracted_values.get('name', ''),
                    'uuid': extracted_values.get('uuid', ''),
                    'locale': extracted_values.get('locale', ''),
                    'definition': extracted_values.get('definition', ''),
                    'rule_category': querie_rules_category
                })

    return extracted_data


@api_view(['POST'])
def upload_workspace_Queries(request):
    if request.method == 'POST' and request.FILES.get('zip_file'):
        zip_file = request.FILES['zip_file']
        
        temp_dir = 'temp_extracted_folder'
        os.makedirs(temp_dir, exist_ok=True)
        
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(temp_dir)
        
        extracted_data_list = extract_queries_files(temp_dir)  
 
       
        
        for data in extracted_data_list:
            rule = Queries.objects.create(
                file_name=data['file_name'],
                parent_folder=data['parent_folder'],
                name=data['name'],
                uuid=data['uuid'],
                locale=data['locale'],
                definition=data['definition'],
                rule_category=data['rule_category']
            )
        
        # Clean up temporary directory
        shutil.rmtree(temp_dir)
 # Serialize the extracted data list for JSON response
        serialized_data = []
        for item in extracted_data_list:
            serialized_item = {
                'file_name': item['file_name'],
                'parent_folder': item['parent_folder'],
                'name': item['name'],
                'uuid': item['uuid'],
                'locale': item['locale'],
                'definition': item['definition'],
                'rule_category': item['rule_category'].name  # Assuming you want to include the category name
            }
            serialized_data.append(serialized_item)
        return JsonResponse({'message': 'Files extracted and saved successfully.', 'qry_data': serialized_data})

    return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})




@api_view(['POST'])
def create_rule_category(request):
    if request.method == 'POST':
        serializer = RuleCategorySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)