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
            game = new Hippodrome(Arrays.asList(new Horse("Lucky", 3, 0), new Horse("Bullet", 3, 0 ), new Horse("Flash", 3, 0)));
        game.run();
        game.printWinner();
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
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (Horse horse : horses) {
            if (horse.getDistance() > winner.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("The winner is " + getWinner().getName() + "!");
    }
    public List<Horse> getHorses() {
        return horses;
    }



}
