// Main Class File:    CSE11.java
// File:               SubDirectory.java
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


/* This class includes the 2 constructers and 4 methods needed 
for Ticket in CSE11 Spring quarter 2024. The constructors are listed
here: SubDirectory and SubDirectory.
The methods are listed here: setParentDir, getParentDir, equals, toString.
*/
/**
 * The concrete class Subdirectory extends the abstract class FSDirectory, 
 * which extends the abstract class FSCompenent , and contains one instance 
 * variable.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/


public class SubDirectory extends FSDirectory {
    private FSDirectory parentDir;

    /**
     * No-arg constructor.
     */
    public SubDirectory() {
        super();
    }

    /**
     * Constructor with name.
     * @param name the name of the subdirectory
     */
    public SubDirectory(String name) {
        super(name);
    }

    /**
     * Setter method for parentDir.
     * @param parentDir the parent directory to set
     * This method returns nothing
     */
    public void setParentDir(FSDirectory parentDir) {
        this.parentDir = parentDir;
    }

    /**
     * Getter method for parentDir.
     * @return the parent directory
     * This method returns the parentDir member variable
     */
    public FSDirectory getParentDir() {
        return this.parentDir;
    }

    /**
     * Override equals method to compare the parent directory.
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     * This method takes in an object and returns a boolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SubDirectory)) {
            return false;
        }
        SubDirectory other = (SubDirectory) obj;
        if (!super.equals(other)) {
            return false;
        }
        if (parentDir == null || other.parentDir == null) {
            return parentDir == other.parentDir;
        }
        return parentDir.equals(other.parentDir);
    }

    /**
     * Return the string representation of the SubDirectory object.
     * @return string representation of the SubDirectory
     * This method takes in no parameters and returns a String
     */
    @Override
    public String toString() {
        return "Sub directory: " + getName();
    }
}
