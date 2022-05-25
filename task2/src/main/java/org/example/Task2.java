package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        double e = 0.0000001;

        try {
            String pathCircle = args[0];
            String pathCoordinate = args[1];

            Scanner scanner = new Scanner(new File(pathCircle));

            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double r = scanner.nextDouble();

            scanner = new Scanner(new File(pathCoordinate));

            while (scanner.hasNext()){
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();

                double d =  Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
                if(Math.abs(r - d) < e){
                    System.out.println(0);
                }
              else if(r - d > e){
                    System.out.println(1);

                }
              else if (r - d < -e){
                    System.out.println(2);
                }


            }


        } catch (IOException ex) {ex.printStackTrace();

        }
    }
}
