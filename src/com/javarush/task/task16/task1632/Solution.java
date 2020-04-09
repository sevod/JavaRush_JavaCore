package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new thread1());
        threads.add(new thread2());
        threads.add(new thread3());
        threads.add(new thread4());
        threads.add(new thread5());
    }

    public static void main(String[] args) {
        threads.get(4).start();

    }

    public static class thread1 extends Thread{
        @Override
        public void run() {
            while (true){
            }
        }
    }

    public static class thread2 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()){
            }
            System.out.println("InterruptedException");
        }
    }

    public static class thread3 extends Thread {
        public void run(){
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
    }

    public static class thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()){
            }
        }

        public void showWarning(){
            //System.out.println("showWarning");
            this.interrupt();
        }
    }

    public static class thread5 extends Thread {

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int count = 0;
            String n;
            try {
            while (!(n = reader.readLine()).equals("N"))
                      count += Integer.parseInt(n);
            } catch (IOException e) {
                //e.printStackTrace();
            }
            System.out.println(count);
        }
    }
}