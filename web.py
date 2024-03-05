import re
import xml.etree.ElementTree as ET
from natsort import natsorted
import os

# Function to parse strings.xml and return a dictionary of string names to values
def parse_strings_xml(file_path):
    tree = ET.parse(file_path)
    root = tree.getroot()
    strings = {}
    for string in root.findall('string'):
        name = string.get('name')
        value = string.text.replace('\\n', '\n').replace('\\t', '\t').replace('\\\'', '\'').replace('\\\"', '\"')
        strings[name] = value
    return strings

# Function to extract section contents from a Java file
def extract_section_contents(java_file_path):
    with open(java_file_path, 'r', encoding='utf-8') as file:
        content = file.read()
    sections = re.findall(r"this\.sections\[\d+\] = new Section\((.*?)\);", content, re.DOTALL)
    return sections

# Function to generate Markdown content for each section
def generate_markdown_content(strings_dict, sections, chapter_text, output_dir, markdown_template):
    os.makedirs(output_dir, exist_ok=True)
    for i, section_content in enumerate(sections):
        markdown_content = f'## {chapter_text}\n\n'
        current_heading = None
        processed_choices = set()
        
        combined_pattern = r"R\.string\.(\w+)|R\.raw\.(\w+)|R\.drawable\.(\w+)"
        combined_regex = re.compile(combined_pattern)
        
        lines = section_content.split(',')
        for line in lines:
            matches = combined_regex.findall(line)
            for match in matches:
                if match[0]:
                    ref = match[0]
                    string_value = strings_dict.get(ref, 'Not found')
                    if ref.startswith("pop"):
                        string_value_single_line = string_value.replace('\n', ' ')
                        markdown_content += f'!>**{string_value_single_line}**  \n\n'
                    elif ref.startswith("btn"):
                        current_heading = string_value
                    else:
                        markdown_content += f'{string_value}\n\n'
                elif match[1]:
                    ref = match[1]
                    relative_path = f"../../decomp/app/src/main/res/raw/{ref}.mp3"
                    markdown_content += f'[{ref}]({relative_path} \':include :type=audio\')\n\n'
                elif match[2]:
                    ref = match[2]
                    drawable_dir = "decomp/app/src/main/res/drawable-land-xxxhdpi"
                    file_path_png = f"{drawable_dir}/{ref}.png"
                    file_path_jpg = f"{drawable_dir}/{ref}.jpg"
                    file_path = file_path_png if os.path.exists(file_path_png) else file_path_jpg if os.path.exists(file_path_jpg) else f"{drawable_dir}/{ref}"
                    relative_path = f"../../{file_path}"
                    markdown_content += f'![{ref}]({relative_path})\n\n'
        
            choice_pattern = r"new Choice\(R\.string\.(\w+), (\d+)\)"
            choice_refs = re.findall(choice_pattern, section_content)
            for ref, number in choice_refs:
                if ref not in processed_choices:
                    string_value = strings_dict.get(ref, 'Not found')
                    if string_value == current_heading:
                        button_link = f'{output_dir}/section_{number}.md'
                        markdown_content += f'[{string_value}]({button_link})\n\n'
                        processed_choices.add(ref)
        
        markdown_page = markdown_template.format(section_number=i, chapter_text=chapter_text, section_content=markdown_content)
        with open(f"{output_dir}/section_{i}.md", "w", encoding='utf-8') as markdown_file:
            markdown_file.write(markdown_page)

# Function to generate navigation files (_navbar.md and _sidebar.md)
def generate_navigation_files(output_dir):
    navbar_content = "- Chapter Selection\n"
    for chapter_dir in os.listdir('output'):
        if os.path.isdir(f'output/{chapter_dir}'):
            navbar_content += f'  - [{chapter_dir}](/output/{chapter_dir}/)\n'
    with open('output/_navbar.md', 'w') as navbar_file:
        navbar_file.write(navbar_content)
    
    for chapter_dir in os.listdir('output'):
        if os.path.isdir(f'output/{chapter_dir}'):
            sidebar_content = "- Section Selection\n"
            section_files = [file for file in os.listdir(f'output/{chapter_dir}') if file.endswith('.md') and not file.startswith('_')]
            sorted_section_files = natsorted(section_files) # Use natsorted for natural sorting
            for file in sorted_section_files:
                section_name = file[:-3]
                sidebar_content += f' - [{section_name}](/output/{chapter_dir}/{file})\n'
            with open(f'output/{chapter_dir}/_sidebar.md', 'w') as sidebar_file:
                sidebar_file.write(sidebar_content)

# Function to generate README files in the /output directory and each chapter directory
def generate_readme_files(output_dir):
    # Generate README.md in /output directory
    readme_content = """
# Story Phase

!> Significant spoilers lay ahead, click carefully to avoid...

Select a chapter to play via the drop down in the top right.

"""
    with open('output/README.md', 'w') as readme_file:
        readme_file.write(readme_content)
    
    # Generate README.md in each chapter directory
    for chapter_dir in os.listdir('output'):
        if os.path.isdir(f'output/{chapter_dir}'):
            readme_content = f"""
# {chapter_dir}

Welcome to {chapter_dir}, head to [section_0](/output/{chapter_dir}/section_0.md) to begin...

"""
            with open(f'output/{chapter_dir}/README.md', 'w') as chapter_readme_file:
                chapter_readme_file.write(readme_content)

# Main script execution
if __name__ == "__main__":
    strings_xml_path = "decomp/app/src/main/res/values/strings.xml"
    java_file_path = "decomp/app/src/main/java/com/shadowborne_games/oathsworn/book/Chapter1.java"
    output_dir = "output/chapter1"
    markdown_template = """
# section_{section_number}

{section_content}
"""
    
    strings_dict = parse_strings_xml(strings_xml_path)
    sections = extract_section_contents(java_file_path)
    chapter_text_key = "chapterText1"
    chapter_text = strings_dict.get(chapter_text_key, "No chapter text found")
    
    generate_markdown_content(strings_dict, sections, chapter_text, output_dir, markdown_template)
    generate_navigation_files(output_dir)
    generate_readme_files(output_dir)
