package com.codegym.task.task19.task1907;

/* 
Counting words

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        
        try (FileReader fileReader = new FileReader(file)){
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) {
               char data = (char) fileReader.read();
                stringBuilder.append(data);
            }
            String fullContents = stringBuilder.toString();
            String[] stringsList = fullContents.split("[\\p{Punct}\\s]");
            int count = 0;
            for (String word: stringsList) {
                if (word.equals("world")) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
