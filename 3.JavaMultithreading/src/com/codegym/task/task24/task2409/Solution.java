package com.codegym.task.task24.task2409;

/* 
Online store for jeans

*/

import java.util.List;

public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }
}
