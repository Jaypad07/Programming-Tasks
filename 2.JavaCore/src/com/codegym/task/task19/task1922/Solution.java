package com.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Searching for the right lines

*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("A");
        words.add("B");
        words.add("C");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String console = reader.readLine();
        reader.close();


        try (BufferedReader buff = new BufferedReader(new FileReader(console))){
            while (buff.ready()) {
                String line = buff.readLine();
                int wordCounter = 0;
                int totalWordCount = 0;
                for (String x : words) {
                    Pattern pattern = Pattern.compile(x);
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        wordCounter++;
                    }
                    totalWordCount += wordCounter;
                    wordCounter = 0;
                }
                if (totalWordCount == 2) {
                    System.out.println(line);
                }
            }
        }
    }
}
