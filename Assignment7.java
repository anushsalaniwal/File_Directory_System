//////////////////////////////////////////////////////////////////////////////
// Main Class File:    Assignment7.java
// File:               Assignment7.java
// Quarter:            Spring 2024
//
// Author:             CSE 11 Staff
// Instructor's Name:  Benjamin Ochoa
///////////////////////////////////////////////////////////////////////////////

// This is the class where the main method, 
//along with all applicable unit tests, 
//are executed in CSE11 Spring quarter 2024.

/**
 * The Assignment5 class, simply runs the unit tests for FSComponenet, 
 * FSDirectory, FSFile, HumanReadableFile, ArchiveFile, SubDirectory, 
 * RootDirectory, Assignment7. Once all the unit tests are run, if they are all 
 * passed, the main method will return, "All unit tests passed". If not it will 
 * return "ERROR: Failed test".
 * 
 * Bugs: None.
 *
 * @author Anush Salaniwal.
*/
public class Assignment7 {
    // This method tests the correctness of the FSComponenet, 
    // FSDirectory, FSFile, HumanReadableFile, ArchiveFile, SubDirectory, 
    // RootDirectory, Assignment7.
    // This is also where they are all executed. This method takes has no
    // parameters and returns a boolean.
    private static boolean testOne() {
        RootDirectory root = new RootDirectory("Home");
        HumanReadableFile pic = new HumanReadableFile("cat.png",
                                                      "contents of picture");
        HumanReadableFile rice = new HumanReadableFile("rice.mp3",
                                                      "contents of mp3 file");
        SubDirectory music = new SubDirectory("music");
        root.addComponent(pic);
        root.addComponent(rice);
        root.addComponent(music);

        if (!root.getName().equals("Home")) return false;
        if (!pic.getName().equals("cat.png")) return false;
        if (!rice.getName().equals("rice.mp3")) return false;
        if (!music.getName().equals("music")) return false;

        return true;
    }

   // Test case: Test reading and writing file contents
    private static boolean testTwo() {
        try {
            // Create a HumanReadableFile
            HumanReadableFile file = new HumanReadableFile("test.txt", "");

            // Write contents to the file
            file.setContents("Hello, World!");
            file.outputFileContents("output.txt");

            // Read contents from the file
            file.inputFileContents("output.txt");

            String fileContents = file.getContents();
            System.out.println("Contents read from file: [" + fileContents + "]");
            System.out.println("Expected contents: [" + "Hello, World!\n" + "]");

            // Check if contents were read correctly
            return file.getContents().equals("Hello, World!\n");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            return false;
        }
    }

    // Test case: Test if SubDirectory parent is correctly set
    private static boolean testThree() {
        // Create a root directory
        RootDirectory root = new RootDirectory();

        // Create a subdirectory
        SubDirectory subDir = new SubDirectory("SubDir");

        // Add subdirectory to the root
        root.addComponent(subDir);

        // Check if the parent directory of the subdirectory is set correctly
        return subDir.getParentDir() == root;
    }

    // Test case: Test the equals method
    private static boolean testFour() {
        // Create two HumanReadableFile objects with the same name and contents
        HumanReadableFile file1 = new HumanReadableFile("file.txt", "Contents");
        HumanReadableFile file2 = new HumanReadableFile("file.txt", "Contents");

        // Check if the equals method returns true for equal objects
        return file1.equals(file2);
    }

    // Test case: Test if ArchiveFile name ends with .zip
    private static boolean testFive() {
        // Create an ArchiveFile
        ArchiveFile archiveFile = 
        new ArchiveFile("archive", new FSComponent[0]);

        // Check if the name ends with .zip as specified in the requirements
        return archiveFile.getName().endsWith(".zip");
    }

    // Test case: Test adding duplicate components to a directory
   private static boolean testSix() {
    try {
        // Create a directory
        RootDirectory root = new RootDirectory();

        // Create two files with the same name
        HumanReadableFile file1 = 
        new HumanReadableFile("file.txt", "contents1");
        HumanReadableFile file2 = 
        new HumanReadableFile("file.txt", "contents2");

        // Add the first file to the directory
        root.addComponent(file1);

        // Attempt to add the second file with the same name
        boolean addedDuplicate = root.addComponent(file2);

        // Check if the second file was not added due to having the same name
        return !addedDuplicate && file1.getContents().equals("contents1");
     } catch (Exception e) {
        System.out.println("Exception caught: " + e.getMessage());
        return false;
        }
    }

    /**
     * All unit tests. This method should be executed to ensure that all
     * methods are correctly implemented.
     *
     * @return true if all unit tests passed, false otherwise.
     */
    public static boolean unitTests() {
        if (!testOne()) {
            System.out.println("testOne - Failed");
            return false;
        }
        if (!testTwo()) {
            System.out.println("testTwo - Failed");
            return false;
        }
        if (!testThree()) {
            System.out.println("testThree - Failed");
            return false;
        }
        if (!testFour()) {
            System.out.println("testFour - Failed");
            return false;
        }
        if (!testFive()) {
            System.out.println("testFive - Failed");
            return false;
        }
        if (!testSix()) {
            System.out.println("testSix - Failed");
            return false;
        }
       return true;
    }

    // This method prints out all unit tests passed if all the unit test passed 
    // and prints Error: Failed test if not all the unit tests were passed.
    // This method takes in a String array and returns nothing.
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
        }
        // Don't need to write code here!
    }
}
