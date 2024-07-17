// Main Class File:    CSE11.java
// File:               HumanReadableFile.java
// Quarter:            CSE 11 Spring 2024
//
// Author:             Anush Salaniwal.
// Email:              ansalaniwal@ucsd.edu
// Instructor's Name:  Professor Ochoa.
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          None.
//
// Online sources:   None.


/* This class includes the 2 constructers and 6 methods needed 
for Ticket in CSE11 Spring quarter 2024. The constructors are listed
here: HumanReadableFile and HumanReadableFile.
The methods are listed here: getContents, setContents, outputFileContents, 
inputFileContents, equals, toString.
*/
/**
 * The The HumanReadableFile class extends the FSFile abstract class and 
 * contains one instance variable.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

import java.io.*;
import java.util.Scanner;

public class HumanReadableFile extends FSFile {
    private String contents;

    /**
     * No-arg constructor.
     */
    public HumanReadableFile() {
    }

    /**
     * Constructor with name and contents.
     * @param name the name of the file
     * @param contents the contents of the file
     * Implement this constructor by initializing the name instance variable in 
     * FSComponent. Then, set the contents instance variable
     */
    public HumanReadableFile(String name, String contents) {
        super(name);
        this.contents = contents;
    }

    /**
     * Getter method for contents.
     * @return contents of the file
     * Getter method for . Simply return contents.
     * This method takes in no parameters and returns a String
     */
    public String getContents() {
        return contents;
    }

    /**
     * Setter method for contents.
     * @param contents contents to be set
     * Setter method for . Simply set the instance variable to the 
     * contents that is passed in
     * This method takes in a String and returns nothing
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * Writes the contents of the file to the specified output file.
     * @param outputFileName the name of the output file
     * This method must write the contents field to a file named outputFileName, 
     * that is in the current directory. If contents is null or empty, then you 
     * must throw an instance of the Exception class with the message "Empty 
     * File contents!" otherwise, write contents and then terminate the line to 
     * the output file using PrintWriter. If a file named outputFileName already 
     * exists in the current directory, then overwrite the original file.
     * This method takes in a String and returns nothing
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception {
        if (contents == null || contents.isEmpty()) {
            throw new Exception("Empty file contents!");
        }
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println(contents);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads the contents from the specified input file into the contents field.
     * @param inputFileName the name of the input file
     * @throws Exception if an I/O error occurs
     * This method must read in all contents from a file named into the instance 
     * variable contents
     * This mtethod takes in a String and returns nothign
     */
    
    public void inputFileContents(String inputFileName) throws Exception {
        try {
            File file = new File(inputFileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("");
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNext()) {
                String token = scanner.next(); 
                sb.append(token);
            }
            scanner.close();
            contents = sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    /**
     * Override equals method to compare the contents of the file.
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     * This method takes in an object and returns a boolean
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HumanReadableFile)) return false;
        if (!super.equals(obj)) return false;
        HumanReadableFile other = (HumanReadableFile) obj;
        return contents.equals(other.contents);
    }

    /**
     * Returns the string representation of the HumanReadableFile object.
     * @return string representation of the HumanReadableFile
     * This method returns the string representation of the HumanReadableFile 
     * object.
     * This method takes in no parameters and returns a String
     */
    @Override
    public String toString() {
        return "Human readable file: " + getName();
    }
}

