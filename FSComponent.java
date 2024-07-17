// Main Class File:    CSE11.java
// File:               FSComponent.java
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


/* This class includes the 2 constructers and 1 method needed 
for FSComponent in CSE11 Spring quarter 2024. The constructors are listed
here: FSComponent and FSComponent.
The methods are listed here: equals.
*/
/**
 * The FSComponent abstract class gives components details which will be used in
 * other classes.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

public abstract class FSComponent {
    private String name;

    /**
     * No-arg constructor.
     * DO NOT CHANGE!
     */
    protected FSComponent() {}

    /**
     * Public constructor that takes in a String.
     * DO NOT CHANGE!
     *
     * @param name the name of the FSComponent
     */
    protected FSComponent(String name) {
        this.name = name;
    }

    /**
     * Public getter that retrieves instance variable - name
     * DO NOT CHANGE!
     *
     * @return instance variable - name
     */
    public String getName() {
        return name;
    }

    /**
     * Public setter that mutates instance variable - name
     * DO NOT CHANGE!
     * @param name instance variable - name
     */
    public void setName(String name) {
        this.name = name;
    }
    // Override the public method equals inherited from Object class. An 
    // FSComponent object is equal to another object if that object is of type.
    // This method takes in an Object and returns a boolean.  
   @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FSComponent)) {
            return false;
        }
        FSComponent other = (FSComponent) obj;
        return name.equals(other.name);
    }

    /* The following four abstract methods need
     * to be implemented by its subclasses.
     * DO NOT CHANGE! */
    public abstract void setParentDir(FSDirectory dir);
    public abstract boolean isFile();
    public abstract boolean isDirectory();
}