package com.codegym.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Yet another adapter

*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
        @Override
        public Person read() throws IOException, ParseException {
            String firstName = fileScanner.next();
            String middleName = fileScanner.next();
            String lastName = fileScanner.next();
            String bday = fileScanner.nextLine();
            Date birth = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(bday);
            return new Person(lastName, firstName, middleName, birth);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
