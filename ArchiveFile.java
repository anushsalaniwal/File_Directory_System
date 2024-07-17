// Main Class File:    CSE11.java
// File:               ArchiveFile.java
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


/* This class includes the 2 constructers and 3 methods needed 
for Ticket in CSE11 Spring quarter 2024. The constructors are listed
here: ArchiveFile and ArchiveFile.
The methods are listed here: outputFileContents, equals, and toString.
*/
/**
 * The ArchiveFile class extends the FSFile abstract class and contains one 
 * instance variable.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

public class ArchiveFile extends FSFile {
    private FSComponent[] componentArray;

    /**
     * No-arg constructor.
     */
    public ArchiveFile() {
        super();
    }

    /**
     * Constructor with name and componentArray.
     * @param name the name of the file
     * @param componentArray array of FSComponent objects
     */
    public ArchiveFile(String name, FSComponent[] componentArray) {
        super(name.endsWith(".zip") ? name : name + ".zip");
        this.componentArray = deepCopy(componentArray);
    }

    /**
     * Writes the names of each stored component in the componentArray to
     * the output file.
     * @param outputFileName the name of the output file
     * @throws Exception if componentArray is null or empty
     * This method takes in a String and returns nothing
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception {
        if (componentArray == null || componentArray.length == 0) {
            throw new Exception("Empty file contents!");
        }

        try (java.io.PrintWriter out =
         new java.io.PrintWriter(new java.io.FileWriter(outputFileName))) {
            for (FSComponent component : componentArray) {
                out.println(component.getName());
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Override equals method to compare the contents of the file.
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     * This method takes in an Object and returns a boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ArchiveFile)) {
            return false;
        }
        ArchiveFile other = (ArchiveFile) obj;
        if (!super.equals(other)) {
            return false;
        }
        if (componentArray == null || other.componentArray == null) {
            return componentArray == other.componentArray;
        }
        if (componentArray.length != other.componentArray.length) {
            return false;
        }
        for (int i = 0; i < componentArray.length; i++) {
            if (!componentArray[i].equals(other.componentArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the string representation of the ArchiveFile object.
     * @return string representation of the ArchiveFile
     * This method takes in no parameters and returns a String
     */
    @Override
    public String toString() {
        return "Archive file: " + getName();
    }

    // Helper method to perform deep copy of componentArray
    private FSComponent[] deepCopy(FSComponent[] original) {
        if (original == null) {
            return null;
        }
        FSComponent[] copy = new FSComponent[original.length];
        for (int i = 0; i < original.length; i++) {
            if (original[i] instanceof HumanReadableFile) {
                copy[i] = new HumanReadableFile(original[i].getName(), 
                ((HumanReadableFile) original[i]).getContents());
            } else if (original[i] instanceof SubDirectory) {
                copy[i] = new SubDirectory(original[i].getName());
            }
        }
        return copy;
    }
}