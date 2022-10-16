package com.codegym.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Method in a try-catch

*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt()){
                int num = scanner.nextInt();
                list.add(num);
            }throw new RuntimeException();
        }catch (Exception e) {
            for (Integer x : list) {
                System.out.println(x);
            }
        }



    }
}
