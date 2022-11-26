package com.codegym.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1))) {
            while (fileReader.ready()) {
                list1.add(fileReader.readLine());
            }
        }

        try (BufferedReader fileReader2 = new BufferedReader(new FileReader(file2))){
            while (fileReader2.ready()) {
                list2.add(fileReader2.readLine());
            }
        }

        int counter1 = 0;
        int counter2 = 0;


       if (list1.size() < list2.size()) {
           while (list1.size() < list2.size()) {
               list1.add("");
           }
       }else {
           while (list2.size() < list1.size()) {
               list2.add("");
           }
       }

            for (int i = 0; i < list2.size(); i++, counter1++, counter2++) {
                if (list1.get(counter1).equals(list2.get(counter2))) {
                    lines.add(new LineItem(Type.SAME, list2.get(counter2)));
                } else if (!(list1).contains(list2.get(counter2))){
                    lines.add(new LineItem(Type.ADDED, list2.get(counter2)));
                    counter1--;
                } else if (!(list1.get(counter1).equals(list2.get(counter2)))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(counter1)));
                    counter2--; i--;
                }if (counter1 + 1 == list2.size() && counter2 != list2.size()) {
                    counter1--;
                }
            }

        for (LineItem x : lines) {
            System.out.println(x.toString());
        }
    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        public Type getType() {
            return type;
        }

        public String getLine() {
            return line;
        }

        public String toString() {
            return String.format("LineItem{%s - %s}", type, line);
        }
    }
}
