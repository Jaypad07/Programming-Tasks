package com.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;


/* 
Building a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<File, Integer> map = new HashMap<>();
        LinkedHashMap<File, Integer> sortedSet = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        File file;
        String destin = fileName.substring(0,fileName.lastIndexOf('.'));

        while (!fileName.equals("end")) {
            file = new File(fileName);
            String[] numSort = fileName.split("\\.part");
            map.put(file, Integer.valueOf(numSort[1]));
            fileName = reader.readLine();
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int num : list) {
            for (Entry<File, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedSet.put(entry.getKey(), num);
                }
            }
        }
        File file1 = new File(destin);
//        for (File x : sortedSet.keySet()) {
//            System.out.println(x);
//        }
//        System.out.println(destin);

        for (File files : sortedSet.keySet()) {
            try (BufferedInputStream reader2 = new BufferedInputStream(new FileInputStream(files)); BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file1, true))) {
                while (reader2.available() > 0)
                    writer.write(reader2.read());
            }
        }
    }
}