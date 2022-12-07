package com.codegym.task.task19.task1923;

/* 
Words with numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            while (reader.ready()) {
                String line = reader.readLine();
                String[] strArray = line.split(" ");
                for (String x: strArray) {
                    if (x.matches("(.*)\\d(.*)")) {
                        writer.write(x + " ");
                    }
                }
            }
        }
    }
}
