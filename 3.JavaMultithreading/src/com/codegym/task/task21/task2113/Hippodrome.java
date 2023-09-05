package com.codegym.task.task21.task2113;

import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;
    private List<Horse> horses;
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(Arrays.asList(new Horse("Lucky", 3, 0), new Horse("Lightning", 3, 0 ), new Horse("Flash", 3, 0)));
        game.run();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse run : horses) {
            run.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public List<Horse> getHorses() {
        return horses;
    }



}
