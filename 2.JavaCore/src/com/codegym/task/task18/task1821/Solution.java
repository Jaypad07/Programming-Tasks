package com.codegym.task.task18.task1821;

/* 
Symbol frequency

*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(args[0])) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < 256; i++) {
                treeMap.put(i, 0);
            }
            int ch;
            while ((ch = inputStream.read()) != -1) {
                        treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
                    }

            for (Map.Entry<Integer, Integer> x : treeMap.entrySet()) {
                if (x.getValue() > 0) {
                    int sart = x.getKey();
                    System.out.println((char) sart + " " + x.getValue());
                }
            }
        }
    }
}
