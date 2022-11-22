package com.codegym.task.task18.task1827;

/* 
Prices

*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if ("-c".equals(args[0])) {
                    String proName = args[1];
                    String pri = args[2];
                    String quan = args[3];


            while (proName.length() < 30) {
                proName += " ";
            }
            while (pri.length() < 8) {
                pri += " ";
            }
            while (quan.length() < 4) {
                quan += " ";
            }

            ArrayList<String> prevList = new ArrayList<>();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                while (fileReader.ready()) {
                    String data = fileReader.readLine();
                    prevList.add(data);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
                for (String y : prevList) {
                    writer.write(y);
                    writer.newLine();
                }


                String maxId = prevList.get(prevList.size() - 1).substring(0, 8).trim();
                int iden = Integer.parseInt(maxId);
                iden++;
                String id = String.valueOf(iden);

                while (id.length() < 8) {
                    id += " ";
                }
                String line = id + proName + pri + quan;
                writer.write(line);
            }
            prevList.clear();
        }
    }
}
//-c "SwimTrunks, blue" 159.00 12

//    public static void addProduct(String file, String productName, String price, String quantity) throws IOException {
//        List<String> allArticles = readArticles(file);
//
//        String id = getNewID(allArticles);
//        productName = format(productName, 30);
//        price = format(price, 8);
//        quantity = format(quantity, 4);
//        allArticles.add(id + productName + price + quantity);
//
//        writeArticles(file, allArticles);
//    }
//
//
//    private static String format(String s, int size) {
//        StringBuilder sb = new StringBuilder(s);
//        while (sb.length() < size)
//            sb.append(" ");
//        return sb.toString();
//    }
//
//    private static String getNewID(List<String> articles) {
//        String idString = articles.get(articles.size() - 1).substring(0, 8).trim();
//        int id = (Integer.parseInt(idString)) + 1;
//        return format(String.valueOf(id), 8);
//    }
//
//    private static List<String> readArticles(String file) throws IOException {
//        ArrayList<String> articles = new ArrayList<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
//            while (fileReader.ready()) {
//                String line = fileReader.readLine();
//                if (!(line.equals(""))) // added check for empty line
//                    articles.add(line);
//            }
//        }
//        return articles;
//    }
//
//    private static void writeArticles(String file, List<String> articles) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            for (String y : articles) {
//                writer.write(y);
//                writer.write(System.lineSeparator());
//            }
//        }
//    }


//Another Alternate Solution:
//public static void main(String[] args) throws Exception {
//
//    if (args.length < 1) return;
//
//    String fileName;
//    try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
//        fileName = console.readLine();
//    }
//
//    switch(args[0]) {
//        case "-c":
//            addProduct(fileName, args);
//            break;
//    }
//}
//
//    private static void addProduct(String fileName, String[] args) throws IOException {
//        List<String> articles = readArticles(fileName);
//
//        int nextId = getLastArticleId(articles) + 1;
//        int pos = 0;
//        articles.add(String.format("%-8s%-30s%-8s%-4s", nextId, args[++pos], args[++pos], args[++pos]));
//
//        writeArticles(fileName, articles);
//    }
//
//    private static int getLastArticleId(List<String> articles) {
//        return Integer.parseInt(articles.get(articles.size() - 1).substring(0, 8).trim());
//    }
//
//    private static List<String> readArticles(String fileName) throws IOException {
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
//            return in.lines().collect(Collectors.toList());
//        }
//    }
//    private static void writeArticles(String fileName, List<String> articles) throws IOException {
//        try (PrintWriter out = new PrintWriter(fileName)) {
//            articles.forEach(out::println);
//        }
//    }