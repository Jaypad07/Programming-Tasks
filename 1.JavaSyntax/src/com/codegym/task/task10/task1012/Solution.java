package com.codegym.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/* 
Number of letters

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Alphabet
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<>();
        for (char letter : abcArray) {
            alphabet.add(letter);
        }

        // Read in strings
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        int[] countArray = new int[26];
        int arrayCounter = 0;
        for (char letter : alphabet) {
            int num = 0;
            for (String word : list) {

                char[] words = word.toCharArray();
                for (char x : words) {
                    if (x == letter) {
                        num++;
                    }
                }
            }countArray[arrayCounter] = num;
            arrayCounter++;
        }
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.print(alphabet.get(i) + " " + countArray[i]);
            System.out.println();
        }
    }
}
