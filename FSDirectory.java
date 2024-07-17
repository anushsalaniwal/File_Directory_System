// Main Class File:    CSE11.java
// File:               FSDirectory.java
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


/* This class includes the 2 constructers and 5 methods needed 
for Ticket in CSE11 Spring quarter 2024. The constructors are listed
here: FSDirectory ad FSDirectory.
The methods are listed here: isFile, isDirectory, addComponent, 
outputComponentNames, and equals.
*/
/**
 * The FSDirectory abstract class inherits directly from the FSComponent 
 * abstract class. The FSDirectory class has one instance variable.
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class FSDirectory extends FSComponent {

    private ArrayList<FSComponent> componentList;

    /**
     * No-arg constructor.
     */
    protected FSDirectory() {
        super("FSDirectory");
    }

    /**
     * Constructor with name.
     * @param name the name of the directory
     */
    protected FSDirectory(String name) {
        super(name);
        this.componentList = new ArrayList<>();
    }
    // Returns true only if this FSComponent is an FSFile
    // This method takes in no parameters and returns a boolean
    @Override
    public boolean isFile() {
        return false;
    }
    // Returns true only if this FSComponent is an FSDirectory
    // This method takes in no parameters and returns a boolean
    @Override
    public boolean isDirectory() {
        return true;
    }

    /**
     * Public getter that retrieves instance variable - componentList.
     * DO NOT CHANGE!
     *
     * @return the componentList instance variable
     */
    public ArrayList<FSComponent> getComponentList() {
        return this.componentList;
    }

    /**
     * Public setter that mutate instance variable - componentList.
     * DO NOT CHANGE!
     * @param componentList the new componentList variable to be assigned
     */
    public void setComponentList(ArrayList<FSComponent> componentList) {
        this.componentList = componentList;
    }

    /**
     * Add a component to the end of the componentList.
     * DO NOT CHANGE!
     *
     * @param newComp the new component to be appended
     */
    public void appendComponent(FSComponent newComp) {
        this.componentList.add(newComp);
        newComp.setParentDir(this);
    }

    /**
     * Add a component to the end of the componentList.
     * @param newComp the new component to be appended
     * @return true if the component was added successfully, false otherwise
     * This method returns a boolean
     */
    public boolean addComponent(FSComponent newComp) {
        if (newComp.isFile()) {
            for (FSComponent comp : componentList) {
                if (comp.getName().equals(newComp.getName())) {
                    return false;
                }
            }
        } else {
            for (FSComponent comp : componentList) {
                if (comp.isDirectory() && 
                comp.getName().equals(newComp.getName())) {
                    return false;
                }
            }
        }
        newComp.setParentDir(this);
        componentList.add(newComp);
        return true;
    }

    /**
     * Write the names of the components stored in the componentList to the 
     * output file.
     * @param outputFileName the name of the output file
     * @throws Exception if componentList is null or empty
     * This method takes in a String and returns nothing 
     */
    public void outputComponentNames(String outputFileName) throws Exception {
        if (componentList == null || componentList.isEmpty()) {
            throw new Exception("Empty directory contents!");
        }

        try (PrintWriter out = new PrintWriter(outputFileName)) {
            for (FSComponent component : componentList) {
                out.println(component.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Override equals method to compare the contents of the directory.
     * @param obj the object to compare with
     * @return true if equal, false otherwise
     * This method takes in an Object ad returns a boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FSDirectory)) {
            return false;
        }
        FSDirectory other = (FSDirectory) obj;
        if (!super.equals(other)) {
            return false;
        }
        if (componentList == null || other.componentList == null) {
            return componentList == other.componentList;
        }
        if (componentList.size() != other.componentList.size()) {
            return false;
        }
        for (int i = 0; i < componentList.size(); i++) {
            if (!componentList.get(i).equals(other.componentList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
