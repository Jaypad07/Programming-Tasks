package com.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
John Johnson

*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            while (reader.ready()) {
                String line = reader.readLine();
               String[] strArray = line.split("(\\s)(?=\\d)", 2);
                SimpleDateFormat format = new SimpleDateFormat("MM dd yyyy");
                Date birthDate = format.parse(strArray[1]);
               PEOPLE.add(new Person(strArray[0], birthDate));
            }
        }
    }
}