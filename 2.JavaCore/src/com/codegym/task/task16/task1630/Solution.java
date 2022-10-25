package com.codegym.task.task16.task1630;

import java.io.*;
import java.util.Scanner;


public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {

        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = buff.readLine();
            secondFileName = buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContents());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContents();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String contents = "";
        String file = "";

        @Override
        public void run() {
            try (Scanner scanner = new Scanner(new FileReader(file))) {
                while (scanner.hasNextLine()) {
                   contents += scanner.nextLine() + " ";
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void setFileName(String fullFileName) {
           file = fullFileName;
        }

        @Override
        public String getFileContents() {
            if (contents != null) {
                return contents;
            }else return "";

        }

    }

    }
//C:\Users\jaypa\Documents\Codegym\CodeGymTasks\2.JavaCore\src\com\codegym\task\task16\task1630\Test1
//C:\Users\jaypa\Documents\Codegym\CodeGymTasks\2.JavaCore\src\com\codegym\task\task16\task1630\Test2