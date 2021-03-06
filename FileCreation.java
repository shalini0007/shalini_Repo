package com.filecreate;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

class FileCreation {
    public static void main(String[] args) {

        // how to create a file in java - import java.io.File and
        // java.io.IOException(for exceptions)

        File first = new File("C:\\Shaily\\FileHandling\\MainFile.txt");
        try {
            if (first.createNewFile()) {
                System.out.println("File" + first.getName() + " created");
            } else {
                System.out.println("File already exists ");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error occured");
            exception.printStackTrace();
        }

        // checking on various operation on created files - import java.io.FileWriter

        if (first.exists()) {
            System.out.println("The Name of the file " + first.getName());
            System.out.println("File Is Readable  " + first.canRead());
            System.out.println("File is Writable  " + first.canWrite());
            System.out.println("File's Absolute Path  " + first.getAbsolutePath());
            System.out.println("File's size " + first.length());
        } else {
            System.out.println("File does not exists ");
        }

        // how to write something or fill data into the file
        try {
            FileWriter filewriter = new FileWriter("C:\\Shaily\\FileHandling\\MainFile.txt");
            filewriter.write(
                    "Welcome to the new file  here");
            filewriter.close();
            System.out.println("content succesfully  wrote on the file ");
        } catch (IOException e) {
            System.out.println("Unexpected exception");
            e.printStackTrace();
        }

        // how to read from the file
        try {
            FileReader filereader = new FileReader("C:\\Shaily\\FileHandling\\MainFile.txt");
            Scanner filereaderdata = new Scanner(filereader);
            while (filereaderdata.hasNextLine()) {
                String filedata = filereaderdata.nextLine();
                System.out.println("File content is :\n" + filedata);
            }
            filereaderdata.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found  ");
            ex.printStackTrace();
        }

        // deleting a file
         //File deletefile = new File("C:\\Shaily\\FileHandling\\MainFile.txt");
         //if (deletefile.delete()) {
         //System.out.println(deletefile.getName() + "File is successfully deleted");
         //} else {
         //System.out.println("Error occured");
         }

    }

