package com.codegym.task.task19.task1905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Reinforce the adapter

*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();

    public static void main(String[] args) {

    }

    static {
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR", "France");
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String country = "";
            for (Map.Entry<String, String> x : countries.entrySet()) {
                if (x.getValue().equals(customer.getCountryName())) {
                     country = x.getKey();
                }
            }
            return country;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] first = contact.getName().split(",");
            return first[1].trim();
        }

        @Override
        public String getContactLastName() {
            String[] last = contact.getName().split(",");
            return last[0].trim();
        }

        @Override
        public String getDialString() {
            String[] phoneNum = contact.getPhoneNumber().split(",");
            String dialNum = phoneNum[0].replaceAll("[+()-]", "");
            return "callto://+" + dialNum;
        }
    }

    public static interface RowItem {
        String getCountryCode();        // For example: US
        String getCompany();            // For example: CodeGym Ltd.
        String getContactFirstName();   // For example: John
        String getContactLastName();    // For example: Peterson
        String getDialString();         // For example: callto://+11112223333
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.
        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Peterson, John
        String getPhoneNumber();        // For example: +1(111)222-3333, +3(805)0123-4567, +380(50)123-4567, etc.
    }
}