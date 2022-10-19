package com.codegym.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Writing to a file from the console

*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String fil = scan.nextLine();
            boolean exit = false;
            String s;
            Scanner scanner = new Scanner(System.in);

            ArrayList<String> arrayList = new ArrayList<>();
            while (!exit) {
                s = scanner.nextLine();
                arrayList.add(s);
                if (s.equals("exit")) {
                    exit = true;
                }
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fil))) {
                for (String x : arrayList) {
                    writer.write(x);
                    writer.newLine();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }catch (Exception e) {
            System.out.println();
        }




    }
}
