package com.codegym.task.task19.task1910;

/* 
Punctuation

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1)); BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2))){
            StringBuilder builder = new StringBuilder();
            while (fileReader.ready()) {
                char data = (char) fileReader.read();
                builder.append(data);
            }
            String readFile = builder.toString().replaceAll("[\\p{Punct}\\n]", "");
            fileWriter.write(readFile);
        }
    }
}
