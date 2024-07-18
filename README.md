# File_Directory_System

## Overview
This project implements a simplified abstraction of a file system (FS) in Java. The file system supports creating, deleting, renaming, and moving files and directories. The project demonstrates the use of abstract and concrete classes, inheritance, and text file input/output (I/O).

## Features
- Abstract and concrete classes to represent file system components.
- Operations to create, delete, rename, and move files and directories.
- Read from and write to text files to store file system contents.

## File Structure
The project includes the following files:

- `FSComponent.java` - Abstract class representing a file system component.
- `FSFile.java` - Abstract class representing a file in the file system.
- `HumanReadableFile.java` - Concrete class representing a human-readable file.
- `ArchiveFile.java` - Concrete class representing an archived file.
- `FSDirectory.java` - Abstract class representing a directory in the file system.
- `SubDirectory.java` - Concrete class representing a subdirectory.
- `RootDirectory.java` - Concrete class representing the root directory.
- `Main.java` - Main class for testing the file system.

## Classes and Methods

### FSComponent
Abstract class representing a file system component with a name.
- `equals(Object obj)` - Checks if two FSComponent objects are equal.

### FSFile
Abstract class representing a file in the file system.
- `FSFile(String name)` - Constructor to initialize the file name.
- `isFile()` - Returns true if the component is a file.
- `isDirectory()` - Returns true if the component is a directory.
- `equals(Object obj)` - Checks if two FSFile objects are equal.
- `outputFileContents(String outputFileName)` - Abstract method to output file contents.

### HumanReadableFile
Concrete class representing a human-readable file.
- `HumanReadableFile(String name, String contents)` - Constructor to initialize the file name and contents.
- `getContents()` - Returns the file contents.
- `setContents(String contents)` - Sets the file contents.
- `outputFileContents(String outputFileName)` - Writes the file contents to the specified output file.
- `inputFileContents(String inputFileName)` - Reads the file contents from the specified input file.
- `equals(Object obj)` - Checks if two HumanReadableFile objects are equal.
- `toString()` - Returns the string representation of the file.

### ArchiveFile
Concrete class representing an archived file.
- `ArchiveFile(String name, FSComponent[] componentArray)` - Constructor to initialize the file name and component array.
- `outputFileContents(String outputFileName)` - Writes the names of the components in the array to the specified output file.
- `equals(Object obj)` - Checks if two ArchiveFile objects are equal.
- `toString()` - Returns the string representation of the file.

### FSDirectory
Abstract class representing a directory in the file system.
- `FSDirectory(String name)` - Constructor to initialize the directory name and component list.
- `isFile()` - Returns true if the component is a file.
- `isDirectory()` - Returns true if the component is a directory.
- `addComponent(FSComponent newComp)` - Adds a new component to the directory.
- `outputComponentNames(String outputFileName)` - Writes the names of the components in the directory to the specified output file.
- `equals(Object obj)` - Checks if two FSDirectory objects are equal.

### SubDirectory
Concrete class representing a subdirectory.
- `SubDirectory(String name)` - Constructor to initialize the subdirectory name.
- `setParentDir(FSDirectory parentDir)` - Sets the parent directory.
- `getParentDir()` - Returns the parent directory.
- `equals(Object obj)` - Checks if two SubDirectory objects are equal.

## Getting Started
2. Download the project files and place them in the appropriate directories.
3. Compile the project using the command: `javac *.java`
4. Run the main class to test the file system: `java Main`

## License
This project is licensed under the MIT License.
