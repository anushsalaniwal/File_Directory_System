// Main Class File:    CSE11.java
// File:               FSFile.java
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
here: FSFile and FSFile.
The methods are listed here: isFile, isDirectory, equals, outputFileContents.
*/
/**
 * The FSFile abstract class inherits directly from the FSComponent abstract 
 * class.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

import java.util.ArrayList;

public abstract class FSFile extends FSComponent {

    private FSDirectory parentDir;

    /**
     * No-arg constructor.
     * DO NOT CHANGE!
     */
    protected FSFile() {
        super("FSFile");
    }

    /**
     * Constructor that initializes the name instance variable in its superclass
     * @param name the name of the FSFile
     */
    protected FSFile(String name) {
        super(name);
    }
    // Returns true only if this is an FSFile. This method has no parameters
    // and returns a boolean
    @Override
    public boolean isFile() {
        return true;
    }
    // Returns true only if this FSComponent is an FSDirectory. This method has 
    // no parameters and returns a boolean
    @Override
    public boolean isDirectory() {
        return false;
    }

    /**
     * Public getter that retrieves instance variable - parentDir
     * DO NOT CHANGE!
     *
     * @return instance variable - parentDir
     */
    public FSDirectory getParentDir() {
        return this.parentDir;
    }

    /**
     * Public setter that mutates instance variable - parentDir
     * DO NOT CHANGE!
     *
     * @param parentDir instance variable - parentDir
     */
    public void setParentDir(FSDirectory parentDir) {
        this.parentDir = parentDir;
    }
    // Overrides Object's equals method. This method takes in an Object and 
    // returns a boolean
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FSFile)) {
            return false;
        }
        FSFile other = (FSFile) obj;
        return super.equals(other) && (parentDir == null ? other.parentDir == 
        null : parentDir == (other.parentDir));
    }

    /**
     * Abstract method to output file contents.
     * @param outputFileName the name of the output file
     */
    // FSFile.java
    public abstract void outputFileContents
    (String outputFileName) throws Exception;
}
