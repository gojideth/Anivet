package persistence;


import java.io.*;

public class BillWriter {
    File myObj;
    FileWriter myWriter;

    public File getMyObj() {
        return myObj;
    }

    public void setMyObj(File myObj) {
        this.myObj = myObj;
    }

    public FileWriter getMyWriter() {
        return myWriter;
    }

    public void setMyWriter(FileWriter myWriter) {
        this.myWriter = myWriter;
    }

    public void createBilLFile(){
        try {
            myObj = new File(".\\bills\\Bill.factura");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeExistingFile(String textToWrite){
        try {
            myWriter = new FileWriter(myObj.getPath());
            myWriter.write(textToWrite);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}