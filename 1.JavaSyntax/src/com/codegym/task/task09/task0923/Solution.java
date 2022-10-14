package com.codegym.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Vowels and consonants

*/

public class Solution {
    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws Exception {
        ArrayList<Character> vowelList = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        for (Character x : chars) {
            if (isVowel(x)) {
                vowelList.add((x));
            }else consonants.add(x);
        }
        for (Character v : vowelList) {
            System.out.print(v + " ");
        }
        System.out.println();
        for (Character c : consonants) {
            if (!(Character.isWhitespace(c))) {
                System.out.print(c + " ");
            }
        }
    }

    // The method checks whether a letter is a vowel
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // Convert to lowercase

        for (char d : vowels)   // Look for vowels in the array
        {
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}