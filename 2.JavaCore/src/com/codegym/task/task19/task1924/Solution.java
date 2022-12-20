package com.codegym.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Replacing numbers

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String[] strings;
            while (reader.ready()) {
                String line = reader.readLine();
                strings = line.split("(\\b)");
                for (String ele : strings) {
                    if (ele.matches("\\d+")) {
                        int digit = Integer.parseInt(ele);
                        if (map.containsKey(digit)) {
                            System.out.print(map.getOrDefault(digit,ele));
                        }else System.out.print(ele);
                    }else {
                        System.out.print(ele);
                    }
                }
                System.out.println();
            }
        }
    }
}

////CodeGym's Alternative way of solving this:

//
//    public static void main(String[] args) {
//        String fileName = null;
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            fileName = reader.readLine();
//        } catch (IOException ignored) {
//        }
//
//        String fileLine;
//
//        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
//            while ((fileLine = in.readLine()) != null) {
//                for (Map.Entry<Integer, String> entry : map.entrySet()) {
//                    fileLine = fileLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
//                }
//                System.out.println(fileLine);
//            }
//        } catch (IOException ignored) {
//        }
//    }
//}
