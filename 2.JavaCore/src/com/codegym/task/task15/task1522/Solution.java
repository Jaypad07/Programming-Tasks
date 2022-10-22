package com.codegym.task.task15.task1522;


import java.util.Scanner;

/* 
Reinforce the singleton pattern

*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        switch (str) {
            case Planet.EARTH : thePlanet = Earth.getInstance();
            break;
            case Planet.MOON : thePlanet = Moon.getInstance();
            break;
            case Planet.SUN : thePlanet = Sun.getInstance();
            break;
            default: thePlanet = null;
            break;

        }
    }
}
