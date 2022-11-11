package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        try (FileInputStream inputStream = new FileInputStream(file2); FileOutputStream outputStream = new FileOutputStream(file1);
             FileInputStream inputStream2 = new FileInputStream(file3); FileOutputStream outputStream2 = new FileOutputStream(file1, true)) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                outputStream.write(data);
            }
            while (inputStream2.available() > 0) {
                int data = inputStream2.read();
                outputStream2.write(data);
            }
        }


    }
}
