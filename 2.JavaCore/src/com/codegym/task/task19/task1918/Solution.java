package com.codegym.task.task19.task1918;

/* 
Introducing tags

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()) {
                sb.append(fileReader.readLine());
            }
            String html = sb.toString();

            String[] list;
            String[] list2;
            String[] list3;
            String[] list4;
            list = html.split("(?=<" + tag +">?)");

            StringBuilder next;
            int i = 0;
            for (String x : list) {
                if (x.startsWith("<"+tag+"")) {
                    if (!(x.endsWith("</"+tag+">")) && (tagCounter(tag, x) == 1)) {
                        list3 = x.split("(?<=</"+tag+">)");
                        System.out.println(list3[0]);
                        i++;
                        continue;
                    }
                    if (x.endsWith("</"+tag+">")) {
                        if (tagCounter(tag, x) > 1) {
                           list2 = x.split("(?<=</"+tag+">)");
                            System.out.println(list2[0]);
                            i++;
                            continue;
                        }
                        System.out.println(x);
                        i++;
                        continue;
                    }else {
                            StringBuilder temp = new StringBuilder(x);
                            next = new StringBuilder(list[i + 1]);
                            temp.append(next);
                            if (temp.toString().endsWith("</"+tag+">")) {
                                if (tagCounter(tag, temp.toString()) % 2 == 1) {
                                    list4 = temp.toString().split("(?<=(</"+tag+">){2})(.*?)");
                                    System.out.println(list4[0]);
                                    i++;
                                    continue;
                                }
                                System.out.println(temp);
                            }else {
                                int k = 2;
                                while (!(temp.toString().endsWith("</"+tag+">"))) {
                                    temp.append(list[i + k]);
                                    k++;
                                }
                                System.out.println(temp);
                            }
                     }
                }
                i++;
            }
       }
    }
    public static int tagCounter(String tag, String line) {
        Pattern pattern = Pattern.compile("(</"+tag+">)");
        Matcher  matcher = pattern.matcher(line);
        int tagCounter = 0;
        while (matcher.find()) {
            tagCounter++;
        }
        return tagCounter;
    }
}