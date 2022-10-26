package com.codegym.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
            int num = scanner1.nextInt();
            threads.get(num).start();
            
//        for (Thread x : threads) {
//            x.start();
//
//        }

    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
                try {
                    if (Thread2.interrupted()) {
                       throw new InterruptedException();
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()){
                    System.out.println("Hurray");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                }
            }catch (Exception e) {
            }
        }
        @Override
        public void showWarning() {
                this.interrupt();
        }
    }
    public static class Thread5 extends Thread {

        @Override
        public void run() {
            int result = 0;
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                try {
                    int num = scanner.nextInt();
                    result += num;

                } catch (Exception e) {
                    if (scanner.nextLine().equals("N")) {
                        System.out.println(result);
                        break;
                    }
                }
            }
        }
    }
}