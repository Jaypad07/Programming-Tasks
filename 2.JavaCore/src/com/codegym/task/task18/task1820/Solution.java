package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();


        try(FileInputStream inputStream = new FileInputStream(file1); FileOutputStream outputStream = new FileOutputStream(file2)) {
            ArrayList<String> arrayList = new ArrayList<>();
            StringBuilder str = new StringBuilder();

            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (data != 32) {   //Make sure byte is not a space
                    str.append((char) data);  //Append each byte and turn byte into a character
                    if (inputStream.available() == 0) { //if inputstream is at the end, don't look for space just add the last piece to the array
                        arrayList.add(str.toString());
                    }
                } else {
                    arrayList.add(str.toString()); //If we hit a space, then take our string and put it into an array
                    str = new StringBuilder(); //Reset the string
                }
            }
            for (String x : arrayList) {
                int rounded = (int) Math.round(Double.parseDouble(x)); //Take our Strings from the array and turn them into Doubles and then round them to Integers
                outputStream.write((rounded + " ").getBytes()); //Separate them by spaces and use get bytes to write to the file
            }
        }
    }
}
