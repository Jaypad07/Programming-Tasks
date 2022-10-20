package com.codegym.task.task14.task1414;

/* 
MovieFactory

*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input != null) {
            input = scanner.nextLine();
            if (input.equals("cartoon") || input.equals("thriller") || input.equals("soapOpera")) {

                switch (input) {
                    case "cartoon":
                        System.out.println(MovieFactory.getMovie("cartoon").getClass().getSimpleName());
                        break;
                    case "thriller":
                        System.out.println(MovieFactory.getMovie("thriller").getClass().getSimpleName());
                        break;
                    case "soapOpera":
                        System.out.println(MovieFactory.getMovie("soapOpera").getClass().getSimpleName());
                        break;
                }

            }else {
                MovieFactory.getMovie(input);
                input = null;
            }

        }

        /*
            8. Create a variable movie in the Movie class, and for each entered string (key):
            8.1. Get an object using MovieFactory.getMovie and assign it to the variable movie.
            8.2. Display the result of calling movie.getClass().getSimpleName().
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            // Create a SoapOpera object for the key "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }

    static class Thriller extends Movie{

    }



}
