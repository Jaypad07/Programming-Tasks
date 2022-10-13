package com.codegym.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* 
Software update

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // List of addresses
        HashMap<String, String> addresses = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();

            addresses.put(city, family);
        }

        String search = reader.readLine();
        if (addresses.containsKey(search)){
            String outCity = addresses.get(search);
            System.out.println(outCity);
        } else System.out.println("No address found");
    }
}
