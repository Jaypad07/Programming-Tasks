package com.codegym.task.task19.task1908;

/* 
Picking out numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1)); BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2))){
            String[] list;
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
                char data = (char) fileReader.read();
                stringBuilder.append(data);
            }
            list = stringBuilder.toString().split("[\\s\\n]");
            for (String x : list) {
                if (x.matches("[0-9]+")) {
                    fileWriter.write(x + " ");
                }
            }
        }
    }
}
