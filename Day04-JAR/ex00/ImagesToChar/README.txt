Steps to build the program:

Run commands from ImagesToChar folder. 

Step 1,  Collection of all files:
    find src -name "*.java" > source.txt
Step 2, Compile project:
    javac -d target @source.txt && rm source.txt
Step 3, Run the program:
    java -cp target edu.school21.printer.app.ImagesToChar <symbol for white color> <symbol for black color> <file_name.bmp>
    
    Example:
        java -cp target edu.school21.printer.app.ImagesToChar . 0 it.bmp