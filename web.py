import re
import xml.etree.ElementTree as ET
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
        value = value.replace('\\n', '<br>') # Replace \n with actual newline
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
with open(java_file_path, 'r') as file:
    content = file.read()

# Regular expression pattern to match each section definition
section_pattern = r"this\.sections\[\d+\] = new Section\((.*?)\);"

# Use the findall method to find all occurrences of the pattern
sections = re.findall(section_pattern, content, re.DOTALL)

# Create the output directory for Chapter 1 if it doesn't exist
output_dir = "output/chapter1"
os.makedirs(output_dir, exist_ok=True)

# HTML template for a section
html_template = """
<html>
<head>
    <title>Chapter 1, Section {section_number}</title>
    <style>
    /* On-screen styles */
    @media screen {{
     body {{
        margin: 2em;
        color: #fff;
        background-color: #000;
     }}
     .ref::before {{
        font-weight: bold;
        color: navy;
        content: "Reference ";
     }}
    }}
    /* Print styles */
    @media print {{
     body {{
        margin: 0;
        color: #000;
        background-color: #fff;
     }}
    }}
    </style>
</head>
<body>
    <h2>Chapter 1, Section {section_number}</h2>
    <hr>
    <div id="section_{section_number}">
        {section_content}
    </div>
</body>
</html>
"""

# Fetch the chapter text for Chapter 1
chapter_text_key = "chapterText1" # Correct key for Chapter 1
chapter_text = strings_dict.get(chapter_text_key, "No chapter text found")

# Loop through each section and generate HTML content
for i, section_content in enumerate(sections):
    html_content = f'<h3>{chapter_text}</h3>\n'
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
                html_content += f'<div style="background-color: red; margin: 10px; padding: 10px;">{string_value}</div><br>\n'
            elif ref.startswith("chp") and ref.endswith("_a"):
                html_content += f'<h2>{string_value}</h2>\n'
            elif ref.startswith("btn"):
                current_heading = string_value # Update the current heading
            else:
                html_content += f'<h3>{string_value}</h3>\n'
        
        # Process Choice references
        choice_pattern = r"new Choice\(R\.string\.(\w+), (\d+)\)"
        choice_refs = re.findall(choice_pattern, section_content)
        for ref, number in choice_refs:
            if ref not in processed_choices:
                string_value = strings_dict.get(ref, 'Not found')
                if string_value == current_heading: # Check if the choice text matches the current heading
                    # Generate the link for the button using JavaScript
                    button_link = f'section_{number}.html'
                    html_content += f'<button onclick="window.location.href=\'{button_link}\'">{string_value}</button><br>\n'
                    processed_choices.add(ref) # Mark the reference as processed

        # Process R.raw. references
        raw_pattern = r"R\.raw\.(\w+)"
        raw_refs = re.findall(raw_pattern, line)
        for ref in raw_refs:
            relative_path = f"../../decomp/app/src/main/res/raw/{ref}.mp3"
            html_content += f'<audio controls><source src="{relative_path}" type="audio/mpeg"></audio>\n'
        
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
            html_content += f'<img src="{relative_path}" alt="{ref}"><br>\n'
    
    # Generate HTML for the section, correctly reflecting the 0-based indexing for section number
    html_page = html_template.format(section_number=i, section_content=html_content)
    
    # Save the HTML content to a file in the chapter directory
    with open(f"{output_dir}/section_{i}.html", "w") as html_file:
        html_file.write(html_page)
