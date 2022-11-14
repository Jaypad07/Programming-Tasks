package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
        public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            int frequency = 0;
            for (char i = 0; i < 256; i++) {
                treeMap.put(i, frequency);
            }
            while (inputStream.available() > 0) {
                int data = inputStream.read();

                for (Character key : treeMap.keySet()) {
                    frequency = 0;
                    if (key == (char) data) {
                        frequency++;
                        treeMap.replace(key, treeMap.get(key) + frequency);
                    }
                }
            }
            for (Map.Entry<Character, Integer> x : treeMap.entrySet()) {
                if (x.getValue() > 0) {
                    System.out.println(x.getKey() + " " + x.getValue());
                }
            }
        }
    }
}

// A person on the help forums solution:

//    public static void main(String[] args) throws IOException {
//        try (InputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\jaypa\\Documents\\Codegym\\CodeGymTasks\\2.JavaCore\\src\\com\\codegym\\task\\task18\\task1821\\test.txt"))) {
//            //TreeMap<Integer, Integer> treeMap = new TreeMap<>(); //Option#1 using a tree map
//            int[] freqArr = new int[256]; //Option#2 using an array
//
//            int ch;
//            while ((ch = inputStream.read()) != -1) {
//                freqArr[ch]++;   //Option#2 using an array
//                //treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1); // Option#1 using a tree map
//            }
//
//            char i = 0;
//            for (int x : freqArr) { //Option#2 using an array
//                if (x != 0) {
//                    System.out.println(i + " " + x);
//                }
//                i++;
//            }
//
//            for (Map.Entry<Integer, Integer> x : treeMap.entrySet()) {  // Option#1 using a tree map
//                if (x.getValue() > 0) {
//                    int key = x.getKey();
//                    System.out.println((char) key + " " + x.getValue());
//                }
//            }
//        }
//    }

