package com.codegym.task.task13.task1318;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Reading a file

*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String read = reader.readLine();
            try (FileInputStream InputStream = new FileInputStream(read)) {
                while(InputStream.available()>0) {

                    char c = (char)InputStream.read();

                    System.out.print(c);
            }
            }


        }catch (Exception e) {
            System.out.println(e);
        }
    }
}