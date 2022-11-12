package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        try (FileInputStream inputStream = new FileInputStream(file1)) {
            ArrayList<Integer> file1Contents = new ArrayList<>();

            while (inputStream.available() > 0) {
                 int data = inputStream.read();
                 file1Contents.add(data);
            }

            try (FileOutputStream outputStream = new FileOutputStream(file1); FileInputStream inputStream2 = new FileInputStream(file2)){
                while (inputStream2.available() > 0) { //while file2 has contents
                    int data2 = inputStream2.read(); //reading file2
                    outputStream.write(data2); //write to file1 contents of data2
                }
            }

            try (FileOutputStream outputStream2 = new FileOutputStream(file1, true)){
                int i = 0;
                while (i < file1Contents.size()) {
                    outputStream2.write(file1Contents.get(i));
                    i++;
                }
            }
        }

    }
}
//    CODEGYM SOLUTION
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1);
//             FileInputStream fileInputStream2 = new FileInputStream(fileName2)) {
//
//            while (fileInputStream2.available() > 0) {
//                byteArrayOutputStream.write(fileInputStream2.read());
//            }
//            while (fileInputStream1.available() > 0) {
//                byteArrayOutputStream.write(fileInputStream1.read());
//            }
//        }
//        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1)) {
//            byteArrayOutputStream.writeTo(fileOutputStream);
//        }
//    }
//}