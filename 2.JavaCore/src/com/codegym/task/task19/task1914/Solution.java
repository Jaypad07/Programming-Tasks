package com.codegym.task.task19.task1914;

/* 
Problem solving

*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        PrintStream consoleStream = System.out; //Save previous setting
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //Create ByteArray stream
        PrintStream stream = new PrintStream(outputStream); //Put bytestream array into printstream
        System.setOut(stream); //Set Output contents to stream
        testString.printSomething();
        String[] splitEquation = outputStream.toString().split(" ");

        int a;
        int b;

        if (Integer.parseInt(splitEquation[0]) >= 0) { //Make sure number is greater than 0;
            a = Integer.parseInt(splitEquation[0]);   //if it is set to variable a
        }else throw new Exception();

        if (Integer.parseInt(splitEquation[2]) >= 0) { //Make sure number is greater than 0;
            b = Integer.parseInt(splitEquation[2]);    //if it is set to variable b
        }else throw new Exception();


        String operator = splitEquation[1];   //Operator saved in array[1] as variable operator

        //Create the format and save under equation
        String equation = a + " " + operator + " " + b + " " + splitEquation[3] + " ";


        System.setOut(consoleStream);

        switch (operator) {
            case "+" : System.out.println(equation + (a + b));
                break;
            case "-" : System.out.println(equation + (a - b));
                break;
            case "*" : System.out.println(equation + (a * b));
            break;
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

