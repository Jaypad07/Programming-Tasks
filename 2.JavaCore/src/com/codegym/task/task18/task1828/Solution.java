package com.codegym.task.task18.task1828;

/* 
Prices 2

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        String fileName;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = console.readLine();
        }
        switch (args[0]) {
            case "-u" : updateProduct(fileName, args[1], args[2], args[3], args[4]);
                break;
            case "-d" : deleteProduct(fileName, args[1]);
                break;
        }
    }

    public static void updateProduct(String file, String id, String productName, String price, String quantity) throws IOException {
        List<String> allArticles = readArticles(file);
        int line = locateIDLine(allArticles, id);

        allArticles.remove(line);
        id = format(id, 8);
        productName = format(productName, 30);
        price = format(price, 8);
        quantity = format(quantity, 4);
        allArticles.add(line, id + productName + price + quantity);

        writeArticles(file, allArticles);
    }

    public static void deleteProduct(String file, String id) throws IOException {
        List<String> allArticles = readArticles(file);
        int line = locateIDLine(allArticles, id);
        allArticles.remove(line);

        writeArticles(file, allArticles);
    }

    public static int locateIDLine(List<String> allArticles, String id) throws IOException {
        int lineNum = 0;
        for (String line : allArticles) { //Locate ID
            String StringId = line.substring(0, 8).trim();
            if (StringId.equals(id)) {
                return lineNum;
            }
            lineNum++;
        }
        return -1;
    }

    private static String format(String s, int size) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < size)
            sb.append(" ");
        return sb.toString();
    }
    private static List<String> readArticles(String file) throws IOException {
        ArrayList<String> articles = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                if (!(line.equals(""))) // added check for empty line
                    articles.add(line);
            }
        }
        return articles;
    }

    private static void writeArticles(String file, List<String> articles) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String y : articles) {
                writer.write(y);
                writer.write(System.lineSeparator());
            }
        }
    }
}
