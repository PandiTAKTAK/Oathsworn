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
        value = string.text
        # Unescape escape sequences
        value = value.replace('\\n', '\n') # Replace \n with actual newline
        value = value.replace('\\t', '\t') # Replace \t with actual tab
        value = value.replace('\\\'', '\'') # Replace \' with '
        value = value.replace('\\\"', '\"') # Replace \" with "
        strings[name] = value
    return strings

# Specify the path to strings.xml
strings_xml_path = "decomp/app/src/main/res/values/strings.xml"

# Parse the strings.xml file
strings_dict = parse_strings_xml(strings_xml_path)

# Specify the path to the Chapter1.java file
java_file_path = "decomp/app/src/main/java/com/shadowborne_games/oathsworn/book/Chapter1.java"

# Open the Java file and read its content
with open(java_file_path, 'r', encoding='utf-8') as file:
    content = file.read()

# Regular expression pattern to match each section definition
section_pattern = r"this\.sections\[\d+\] = new Section\((.*?)\);"

# Use the findall method to find all occurrences of the pattern
sections = re.findall(section_pattern, content, re.DOTALL)

# Create the output directory for Chapter 1 if it doesn't exist
output_dir = "output/chapter1"
os.makedirs(output_dir, exist_ok=True)

# Markdown template for a section
markdown_template = """
# section_{section_number}

{section_content}
"""

# Fetch the chapter text for Chapter 1
chapter_text_key = "chapterText1" # Correct key for Chapter 1
chapter_text = strings_dict.get(chapter_text_key, "No chapter text found")

# Loop through each section and generate Markdown content
for i, section_content in enumerate(sections):
    markdown_content = f'## {chapter_text}\n\n'
    current_heading = None # Initialize a variable to track the current heading
    processed_choices = set() # Initialize a set to track processed choices for this section
    
    # Split the section content into lines for sequential processing
    lines = section_content.split(',')
    for line in lines:
        # Process R.string references
        string_pattern = r"R\.string\.(\w+)"
        string_refs = re.findall(string_pattern, line)
        for ref in string_refs:
            string_value = strings_dict.get(ref, 'Not found')
            if ref.startswith("pop"):
                string_value_single_line = string_value.replace('\n', ' ')
                markdown_content += f'!>**{string_value_single_line}**  \n\n'
            elif ref.startswith("chp") and ref.endswith("_a"):
                markdown_content += f'{string_value}\n\n'
            elif ref.startswith("btn"):
                current_heading = string_value # Update the current heading
            else:
                markdown_content += f'{string_value}\n\n'
        
        # Process Choice references
        choice_pattern = r"new Choice\(R\.string\.(\w+), (\d+)\)"
        choice_refs = re.findall(choice_pattern, section_content)
        for ref, number in choice_refs:
            if ref not in processed_choices:
                string_value = strings_dict.get(ref, 'Not found')
                if string_value == current_heading: # Check if the choice text matches the current heading
                    # Generate the link for the button using Markdown
                    button_link = f'{output_dir}/section_{number}.md'
                    markdown_content += f'[{string_value}]({button_link})\n\n'
                    processed_choices.add(ref) # Mark the reference as processed
        
        # Process R.raw. references
        raw_pattern = r"R\.raw\.(\w+)"
        raw_refs = re.findall(raw_pattern, line)
        for ref in raw_refs:
            relative_path = f"../../decomp/app/src/main/res/raw/{ref}.mp3"
            markdown_content += f'[{ref}]({relative_path} \':include :type=audio\')\n\n'
        
        # Process R.drawable. references
        drawable_pattern = r"R\.drawable\.(\w+)"
        drawable_refs = re.findall(drawable_pattern, line)
        for ref in drawable_refs:
            drawable_dir = "decomp/app/src/main/res/drawable-land-xxxhdpi"
            file_path_png = f"{drawable_dir}/{ref}.png"
            file_path_jpg = f"{drawable_dir}/{ref}.jpg"
            if os.path.exists(file_path_png):
                file_path = file_path_png
            elif os.path.exists(file_path_jpg):
                file_path = file_path_jpg
            else:
                file_path = f"{drawable_dir}/{ref}" # Fallback, assuming no extension needed
            relative_path = f"../../{file_path}"
            markdown_content += f'![{ref}]({relative_path})\n\n'
    
    # Generate Markdown for the section, correctly reflecting the 0-based indexing for section number
    markdown_page = markdown_template.format(section_number=i, chapter_text=chapter_text, section_content=markdown_content)
    
    # Save the Markdown content to a file in the chapter directory
    with open(f"{output_dir}/section_{i}.md", "w", encoding='utf-8') as markdown_file:
        markdown_file.write(markdown_page)

# Dynamically generate _navbar.md
navbar_content = "- Chapter Selection\n"
for chapter_dir in os.listdir('output'):
    if os.path.isdir(f'output/{chapter_dir}'):
        navbar_content += f'  - [{chapter_dir}](/output/{chapter_dir}/)\n'

with open('output/_navbar.md', 'w') as navbar_file:
    navbar_file.write(navbar_content)

# Dynamically generate _sidebar.md for each chapter
for chapter_dir in os.listdir('output'):
    if os.path.isdir(f'output/{chapter_dir}'):
        sidebar_content = "- Section Selection\n"
        # Collect all section files in a list
        section_files = [file for file in os.listdir(f'output/{chapter_dir}') if file.endswith('.md') and not file.startswith('_')]
        
        # Sort the section files using natsort
        sorted_section_files = natsorted(section_files)
        
        # Generate sidebar content with sorted section files
        for file in sorted_section_files:
            section_name = file[:-3] # Remove '.md' from the file name
            sidebar_content += f' - [{section_name}](/output/{chapter_dir}/{file})\n'
        
        with open(f'output/{chapter_dir}/_sidebar.md', 'w') as sidebar_file:
            sidebar_file.write(sidebar_content)

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
