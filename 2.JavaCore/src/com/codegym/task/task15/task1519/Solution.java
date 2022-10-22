package com.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Different methods for different types

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                break;
            }
            if (str.matches("((\\+|-)?([0-9]+)(\\.[0-9]+)?)|((\\+|-)?\\.?[0-9]+)")) { //Is a real number
                if (str.contains(".")) {
                    print(Double.parseDouble(str));
                } else if (Integer.parseInt(str) > 0 && Integer.parseInt(str) < 128) {
                    print(Short.parseShort(str));
                } else if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) >= 128) {
                    print(Integer.parseInt(str));
                }
            }else print(str);
        }
    }

    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }

    // CODEGYM: A better Solution
    // public static void main(String[] args) throws IOException {
    //        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    //
    //        String s;
    //        while (!(s = reader.readLine()).equals("exit")) {
    //            try {
    //            if (s.contains(".")) {
    //                print(Double.parseDouble(s));
    //            } else {
    //                    int i = Integer.parseInt(s);
    //                    if (i > 0 && i < 128) {
    //                        print((short) i);
    //                    } else {
    //                        print(i);
    //                    }
    //                }
    //            }
    //            catch (Exception e) {
    //                print((String) s);
    //            }
    //        }
    //        reader.close();
    //    }
}
