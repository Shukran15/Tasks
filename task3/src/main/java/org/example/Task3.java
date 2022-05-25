package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {


        String pathTests = args[0];
        String pathValues = args[1];

        try {
            Scanner scanner = new Scanner(new File(pathTests));
            StringBuilder sbTests = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sbTests.append(line);
            }
            String tests = sbTests.toString();


            scanner = new Scanner(new File(pathValues));
            StringBuilder sbValues = new StringBuilder();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                sbValues.append(line);
            }




            System.out.println(sbValues.toString());
        } catch (IOException ex) {ex.printStackTrace();

        }
    }

}

class Values{

    private int id;
    private String value;

    public Values() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
