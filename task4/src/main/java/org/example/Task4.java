package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {


        try {
            String path = args[0];
            Scanner scanner = new Scanner(new File(path));

            ArrayList<Long> num = new ArrayList<>();
            long sum = 0;
            while (scanner.hasNext()){
                long n = scanner.nextLong();
                sum = sum + n;
                num.add(n);
            }

            long average = sum / num.size();
            long rez = 0;

            for (int i = 0; i < num.size(); i++){
                rez = rez + Math.abs(average - num.get(i));
            }

            System.out.println(rez);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
