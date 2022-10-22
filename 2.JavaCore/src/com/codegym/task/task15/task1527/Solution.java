package com.codegym.task.task15.task1527;


import java.util.*;

/* 
Request parser

*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        LinkedHashMap<String, String> paraVal = new LinkedHashMap<>(); //We need this type of map to keep the same order

        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();

        Scanner reader = new Scanner(url);  //Takes in URL
        reader.useDelimiter("\\?");  //Split URL into two lines between the ? delimiter

        String address = "";
        while (reader.hasNext()) {        //reads next Token (Our two sentences)
             address = reader.next(); //Takes the 2nd line of the URL and stores it as address
        }

        Scanner reader2 = new Scanner(address); //Reads stored URL in the address variable
        reader2.useDelimiter("&");  //splits the line by &

        while (reader2.hasNext()) {
            list.add(reader2.next());  //adds each token that was split by & to the list
        }

        for (String y : list) {     //For each element in list check if it has an = sign
            if (y.contains("=")) {
                int index = y.indexOf("=");  //If it does grab the index to split the String by parameters and values
                paraVal.put(y.substring(0, index),y.substring(index + 1)); // Adds para(keys) and values to Map
            }else {
                paraVal.put(y, null); //If parameter(key) does not have a value, then put in key and put value as null.
            }
        }

        for (Map.Entry<String, String> x : paraVal.entrySet()) {  //Prints parameters(keys)
            System.out.print(x.getKey() + " ");
        }
        System.out.println();

            try {  //If list contains obj parameter, then convert its value to a Double. If it can't convert send to String method
                if (paraVal.containsKey("obj"))
                    alert(Double.parseDouble(paraVal.get("obj")));


            }catch (Exception e) {
                alert(String.valueOf(paraVal.get("obj")));
            }

    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
