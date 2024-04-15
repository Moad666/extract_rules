import os
import re

def extract_brl_files(workspace_path):
    brl_data_dict = {}  # Dictionary to store extracted data

    for root, dirs, files in os.walk(workspace_path):
        for file in files:
            if file.endswith('.brl'):
                file_path = os.path.join(root, file)
                file_name = os.path.splitext(file)[0]  # Extracting the file name without extension
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
                            
                            if file_name in brl_data_dict:
                                brl_data_dict[file_name].append({'if': if_content, 'then': then_content})
                            else:
                                brl_data_dict[file_name] = [{'if': if_content, 'then': then_content}]
    
    return brl_data_dict

# Using your specific workspace path
workspace_path = r'C:\odm_workspace\ODM\TTR'
brl_data_dict = extract_brl_files(workspace_path)

# Example to print the extracted data
for file_name, content_list in brl_data_dict.items():
    print(f"File: {file_name}")
    for idx, content_dict in enumerate(content_list, 1):
        print(f"   Content {idx}:")
        print(f"      If: {content_dict['if']}")
        print(f"      Then: {content_dict['then']}")





# @api_view(['POST'])
# def upload_workspace(request):
#     if request.method == 'POST' and (request.FILES.get('zip_file') or request.data.get('git_link')):
#         temp_dir = 'temp_extracted_folder'
#         os.makedirs(temp_dir, exist_ok=True)

#         if request.FILES.get('zip_file'):
#             zip_file = request.FILES['zip_file']

#             with zipfile.ZipFile(zip_file, 'r') as zip_ref:
#                 zip_ref.extractall(temp_dir)

#         elif request.data.get('git_link'):
#             git_link = request.data['git_link']

#             # Clone the repository from the provided Git link to the temporary directory
#             git.Repo.clone_from(git_link, temp_dir)

#         extracted_data_list = extract_brl_files(temp_dir)

#         # Save extracted data to the database
#         for extracted_data in extracted_data_list:
#             rule = ActionRule.objects.create(
#                 file_name=extracted_data['file_name'],
#                 tag_data=extracted_data['tag_data'],
#                 category=extracted_data['category']
#             )

#         # Clean up temporary directory
#         for item in os.listdir(temp_dir):
#             item_path = os.path.join(temp_dir, item)
#             if os.path.isfile(item_path):
#                 os.remove(item_path)
#             else:
#                 shutil.rmtree(item_path)

#         os.rmdir(temp_dir)

#         return JsonResponse({'message': 'Files extracted and saved successfully.', 'brl_data': [{'file_name': data['file_name'], 'tag_data': data['tag_data'], 'category': data['category'].name} for data in extracted_data_list]})

#     return JsonResponse({'error': 'No zip file uploaded or invalid request method.'})
