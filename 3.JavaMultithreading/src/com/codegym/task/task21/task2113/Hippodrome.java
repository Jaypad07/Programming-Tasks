package com.codegym.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;
    private List<Horse> horses;
    
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }



    
    public static void main(String[] args) {
        game = new Hippodrome(Arrays.asList(new Horse("Lucky", 3, 0), new Horse("Lightning", 3, 0 ), new Horse("Flash", 3, 0)));
    }



}
