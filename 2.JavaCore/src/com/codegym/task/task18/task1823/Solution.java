package com.codegym.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* 
Threads and bytes

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String fileName = reader.readLine();
                if (fileName.equals("exit")) break;
                Thread thread = new ReadThread(fileName);
                thread.start();
            }
        } catch (IOException e) {
        }
    }

    public static class ReadThread extends Thread {
        String runFile;
        public ReadThread(String fileName) throws IOException {
            runFile = fileName;
        }
        @Override
        public void run() {
            int max = Integer.MIN_VALUE;
            try (FileInputStream inputStream = new FileInputStream(runFile)) {
                HashMap<Integer, Integer> freqArr = new HashMap<>();
                int ch;
                while ((ch = inputStream.read()) != -1) {
                    freqArr.put(ch, freqArr.getOrDefault(ch, 0) + 1);
                }
                for (Map.Entry<Integer, Integer> x : freqArr.entrySet()) {
                    if (x.getValue() > max) {
                        max = x.getKey();
                    }
                }
                resultMap.put(runFile, max);

            } catch (IOException e) {

            }
        }

    }
}
