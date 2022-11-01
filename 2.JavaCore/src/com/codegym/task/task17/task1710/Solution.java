package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        switch (args[0]) {
            case "-c": create(args[1], args[2], args[3]);
            break;
            case "-u": update(Integer.parseInt(args[1]), args[2], args[3], args[4]);
            break;
            case "-d": delete(Integer.parseInt(args[1]));
            break;
            case "-i": info(Integer.parseInt(args[1]));
            break;
        }
    }

    public static void create(String name, String sex, String bd) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
        Date updatedBday;
        try {
            updatedBday = formatter.parse(bd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if (sex.equals("f")) {
            allPeople.add(Person.createFemale(name, updatedBday));
        }else if (sex.equals("m")) allPeople.add(Person.createMale(name, updatedBday));
        System.out.println(allPeople.indexOf(allPeople.get(allPeople.size() - 1)));
    }

    public static void update(int ID, String name, String sex, String bd) {
        allPeople.get(ID).setName(name);
        if (sex.equals("f")) {
            allPeople.get(ID).setSex(Sex.FEMALE);
        } else if (sex.equals("m")) {
            allPeople.get(ID).setSex(Sex.MALE);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
        Date updatedBday;
        try {
            updatedBday = formatter.parse(bd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        allPeople.get(ID).setBirthDate(updatedBday);
    }

    public static void delete(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }

    public static void info(int id){
        String bd;
        String sex;

        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

        bd = formatter.format(allPeople.get(id).getBirthDate());


        if (allPeople.get(id).getSex().equals(Sex.FEMALE)){
            sex = "f";
        }else sex = "m";

        System.out.println(allPeople.get(id).getName() + " " + sex + " " + bd);
    }
}
