Steps to build the program:

Run commands from ImagesToChar folder. 

Step 1, Collection of all files:
    find src -name "*.java" > source.txt
Step 2, Compile project:
    javac -d target @source.txt && rm source.txt && cp -R src/resources target/.
Step 3, Create archive:
    jar cmf src/manifest.txt target/images-to-chars-printer.jar -C target .
Step 4, Run the program:
    java -jar target/images-to-chars-printer.jar <charcter to white color> <character to black color>

    Example:
        java -jar target/images-to-chars-printer.jar . 0