package com.codegym.task.task19.task1920;

/* 
The richest

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        String richest = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()) {
                String line = reader.readLine();
                String[] array = line.split(" ");
                double val = Double.parseDouble(array[1]);
                if (treeMap.containsKey(array[0])) {
                    treeMap.replace(array[0], treeMap.get(array[0]) + val );
                }else treeMap.put(array[0], val);
            }

            Double prev = Double.MIN_VALUE;
            for (Map.Entry<String, Double> x: treeMap.entrySet()) {
                if (x.getValue() > prev) {
                    prev = x.getValue();
                    richest = x.getKey();
                } else if (x.getValue().equals(prev)) {
                   arrayList.add(x.getKey());
                }
            }
            arrayList.add(richest);
            Collections.sort(arrayList);
            for (String richPeople : arrayList) {
                System.out.println(richPeople);
            }
        }
    }
}
