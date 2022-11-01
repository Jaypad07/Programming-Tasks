package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here
        switch (args[0]) {
            case "-c":
                for (int i = 1, j = 2, k = 3; k < args.length; i += 3, j+=3, k+=3) {
                synchronized (allPeople){
                    create(args[i], args[j], args[k]);
                    }
                }
            break;
            case "-u":
                for (int i = 1, j = 2, k = 3, m = 4; m < args.length; i += 4, j+=4, k+=4, m+=4) {
                    synchronized (allPeople) {
                        update(Integer.parseInt(args[i]), args[j], args[k], args[m]);
                    }
                }
                break;
            case "-d":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        delete(Integer.parseInt(args[i]));
                    }
                }
                break;
            case "-i":
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        info(Integer.parseInt(args[i]));
                    }
                }
                break;
        }
    }

    public static synchronized void create(String name, String sex, String bd) {

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

    public static synchronized void update(int ID, String name, String sex, String bd) {

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

    public static void delete(int... id) {
        for (int index : id) {
            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDate(null);
        }

    }

    public static synchronized void info(int... id){

        for (int index : id) {
            String bd;
            String sex;

            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

            bd = formatter.format(allPeople.get(index).getBirthDate());

            if (allPeople.get(index).getSex().equals(Sex.FEMALE)){
                sex = "f";
            }else sex = "m";

            System.out.println(allPeople.get(index).getName() + " " + sex + " " + bd);
        }


    }
}
