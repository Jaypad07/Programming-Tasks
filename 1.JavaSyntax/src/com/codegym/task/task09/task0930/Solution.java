package com.codegym.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Task about algorithms

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        int nCount = 0;
        int sCount = 0;

        int[] num = new int[array.length];
        String[] str = new String[array.length];

        for (String x : array) {
            if (isNumber(x)) {
                num[nCount] = Integer.parseInt(x);
                nCount++;

            }else {
                str[sCount] = x;
                sCount++;
            }
        }

        for (int i = 0; i < sCount; i++) {
            for (int j = i; j < sCount; j++) {
                if (isGreaterThan(str[i], str[j])) {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }

        for (int i = 0; i < nCount; i++) {
            for (int j = i; j < nCount; j++) {
                if  (num[i] < num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        int nCounter = 0;
        int aCounter = 0;
        int sCounter = 0;
        for (String b : array) {
            if (isNumber(b)) {
                array[aCounter] = String.valueOf(num[nCounter]);
                aCounter++;
                nCounter++;
            }else {
                array[aCounter] = str[sCounter];
                aCounter++;
                sCounter++;
            }
        }




////print bug tests
//        for (Integer w : num) {
//            System.out.println(w);
//        }
//        System.out.println("-------------------------------------------");
//        for (String q : str) {
//            System.out.println(q);
//        }
//        System.out.println("-------------------------------------------");
    }

    // String comparison method: 'a' is greater than 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Is the passed string a number?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // The string contains a hyphen
                    || (!Character.isDigit(c) && c != '-') // or is not a number and doesn't start with a hyphen
                    || (i == 0 && c == '-' && chars.length == 1)) // or is a single hyphen
            {
                return false;
            }
        }
        return true;
    }
}
