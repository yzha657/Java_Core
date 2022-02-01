package LMS;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Assignment2 {

    //Count how many files/folders are there inside one folder
    //  - the count method should take a parameter called Criteria like this: count(Criteria criteria) -- implemented as method in Criteria class
    //  - For Criteria class, multiple conditions should be included such as: folder path, includeSubFolder or not, the extension of the file be counted and so on.
    //  - Optional: Take the input from keyboard
    //  - Take care of the invalid inputs. Exception handling
    //  - Get proper result displayed.
    public static void main(String[] args) {
        String currentPath = System.getProperty("user.dir");
        File cur = new File(currentPath);
        Criteria criteria = new Criteria(cur);
        System.out.println(criteria);

//        for(String s : cur.list()){
//            System.out.println(s);
//        }

        Scanner input = new Scanner(System.in);

        String inputPath = input.nextLine();
        File inputFile = new File(inputPath);
        while(!inputFile.isDirectory()){
            System.out.println("The input is not valid. Remember it has to be a path to a directory!");
            inputPath = input.next();
            inputFile = new File(inputPath);
        }

        Criteria inputCriteria = new Criteria(inputFile);
        System.out.println(inputCriteria);
    }
}

class Criteria{
    File folder;
    //boolean includeSubfolder;
    int fileCount;
    int folderCount;
    File[] subfiles;

    public Criteria(File folder){
        this.folder = folder;
        subfiles = folder.listFiles();
        count();
    }

    private void count(){
        for(File f : subfiles){
            if(f.isDirectory()) folderCount++;
            else fileCount++;
        }
    }

    public String toString(){
        return "There are " + fileCount + " files and " + folderCount + " folders inside folder " + folder.getAbsolutePath();
    }
}