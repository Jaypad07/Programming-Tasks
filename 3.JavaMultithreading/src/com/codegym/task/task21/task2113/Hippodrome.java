package com.codegym.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;



    public static void main(String[] args) {
        game = new Hippodrome(Arrays.asList(new Horse("Lucky", 3, 0), new Horse("Lightning", 3, 0 ), new Horse("Flash", 3, 0)));
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {

    }



}
