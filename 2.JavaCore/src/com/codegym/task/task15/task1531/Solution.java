package com.codegym.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Factorial

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigDecimal result = new BigDecimal(1);
        if (n <= 150 && n >= 0) {
            for (int i = 1; i <= n; i++) {
                result = result.multiply(new BigDecimal(i));
            }return result.toString();

        }else return String.valueOf(0);


    }
}
