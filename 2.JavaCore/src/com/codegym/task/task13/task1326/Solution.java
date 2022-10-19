package com.codegym.task.task13.task1326;

/* 
Sorting even numbers from a file

*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> str = new ArrayList<>();

        try(Scanner scanner = new Scanner(System.in) ) {
            String s = scanner.nextLine();
            try (DataInputStream dos = new DataInputStream(new FileInputStream(s))){ //Takes in keyboard File source
                BufferedReader reader = new BufferedReader(new InputStreamReader(dos)); //Reads source data
                while (reader.ready()) {
                    String c = reader.readLine();
                    if (Integer.parseInt(c) % 2 == 0) {
                        str.add(Integer.valueOf(c));
                    }

                    /*This Code was screwing me up: It seems that double-digit numbers (When in bytes) are separated
                    by whitespace. This is why I continued to get single digit numbers even though it should have been read
                    as a double-digit. Also, I believe adding the buffer helped by allowing me to read a whole line as a string.
                     Allowing me to pick up double digits. Not sure how it works yet. */

//                    if (!(Character.isWhitespace(Integer.parseInt(c)))) {
//                        chars.add(c);
//                    }
                }
                Collections.sort(str);
                for (Integer x : str) {
                    System.out.println(x);
                }
            }

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}


/*A better way - CodeGym Solution

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        List<Integer> data = new ArrayList<Integer>();

        while (scanner.hasNext())
        {
            int value = scanner.nextInt();
            if (value % 2 == 0) data.add(value);
        }

        Collections.sort(data);

        for (Integer value : data)
            System.out.println(value);

        scanner.close();
        fileInputStream.close();
    }
}*/
