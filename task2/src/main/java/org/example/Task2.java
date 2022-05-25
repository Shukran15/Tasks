package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        float e = 0.00001f;

        try {
            String pathCircle = args[0];
            String pathCoordinate = args[1];

            Scanner scanner = new Scanner(new File(pathCircle));
            float r = scanner.nextFloat();
            float x0 = scanner.nextFloat();
            float y0 = scanner.nextFloat();

            scanner = new Scanner(new File(pathCoordinate));

            while (scanner.hasNext()){
                float x = scanner.nextFloat();
                float y = scanner.nextFloat();

                float d = (float) Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
                System.out.println(d);
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
