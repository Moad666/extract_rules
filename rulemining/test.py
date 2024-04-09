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
