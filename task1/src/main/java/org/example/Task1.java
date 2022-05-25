package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        String path = args[0];

        try {
            Scanner scanner = new Scanner(new File(path));
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            // n = 4; m = 3
            // {1, 2, 3, 4} 123, 341
            // 1 3 1

            // n = 5; m = 4
            // {1, 2, 3, 4, 5} 1234
            // 1 4 2 5 3 1
            // 1 + 4 - 1 = 4, 4 + 4 - 1 = 7, 7 % 5 = 2, 2 + 4 - 1 = 5, 5 + 4 - 1 = 8, 8 % 5 = 3, 3 + 4 - 1 = 6, 6 % 5 = 1

            int p = 1;
            do {
                System.out.print(p);
                p = (p + m - 1) % n;
                if (p == 0) {
                    p = n;
                }

            } while (p != 1);
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
