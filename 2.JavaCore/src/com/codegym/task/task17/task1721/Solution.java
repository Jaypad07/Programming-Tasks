package com.codegym.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = fileReader.readLine();
            String file2 = fileReader.readLine();

            BufferedReader bf = new BufferedReader(new FileReader(file1));
            BufferedReader bf2 = new BufferedReader(new FileReader(file2));

            String line = bf.readLine();

            while (line != null) {
                allLines.add(line);
                line = bf.readLine();
            }

            String line2 = bf2.readLine();

            while (line2 != null) {
                linesForRemoval.add(line2);
                line2 = bf2.readLine();
            }bf.close();
            bf2.close();
            new Solution().joinData();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {

        if (new HashSet<>(allLines).containsAll(linesForRemoval)) {
            for (String str : linesForRemoval) {
                allLines.remove(str);
            }
        }else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
