package com.codegym.task.task18.task1826;

/* 
Encryption

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        switch (args[0]) {
            case "-e" : encryption(args[1], args[2]); //Encryption method
                break;
            case "-d" : decryption(args[1], args[2]); //decryption method
                break;
        }
    }
    public static void encryption(String fileName, String fileOutput) throws IOException {
        ArrayList<Character> list = new ArrayList<>();
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(fileName)); BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileOutput))){
            int data;
            while ((data = reader.read()) != -1) {
                list.add((char) data);
            }
            for (char i : list) {
                i+=7;
                writer.write(i);
            }
        }
    }

    public static void decryption(String fileName, String fileOutput) throws IOException {
        ArrayList<Character> list = new ArrayList<>();
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(fileName)); BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileOutput))){
            int data;
            while ((data = reader.read()) != -1) {
                list.add((char) data);
            }
            for (char i : list) {
                i-=7;
                writer.write(i);
            }
        }
    }
}
