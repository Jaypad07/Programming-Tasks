package com.codegym.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        while (true) {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("An error occurred while trying to enter text. Try again.");
                readString();
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readString().trim());
            }catch (NumberFormatException e) {
                System.out.println("An error while trying to enter a number. Try again.");
                readInt();
            }
        }
    }
}

