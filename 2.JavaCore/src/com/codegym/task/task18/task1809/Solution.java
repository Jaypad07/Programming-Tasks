package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(file1); 
             FileOutputStream fileOutputStream = new FileOutputStream(file2)){
            
           byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer, 0, buffer.length);
                for (int i = buffer.length - 1; i >= 0; i--) {
                    fileOutputStream.write(buffer[i]);
                }

            }
        }

    }
}


//Code Gyms Solution for reverse order
//public static void main(String[] args) throws IOException {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    String inputFile = reader.readLine();
//    String outputFile = reader.readLine();
//
//    try (FileInputStream fileInputStream = new FileInputStream(inputFile);
//         FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
//
//        List<Integer> inputBytes = new ArrayList<>();
//        while (fileInputStream.available() > 0) {
//            inputBytes.add(fileInputStream.read());
//        }
//        Collections.reverse(inputBytes);
//        for (Integer aByte : inputBytes) {
//            fileOutputStream.write(aByte);
//        }
//    }
//}
//}