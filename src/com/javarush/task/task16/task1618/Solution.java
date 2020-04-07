package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread testThread = new TestThread();
        testThread.start();
        //Thread.sleep(2000);//test
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run(){
            Thread current = Thread.currentThread();
            //System.out.println(this.isInterrupted());
            while (!this.isInterrupted()) {
                //System.out.println(current.isInterrupted());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    this.interrupt();
                    //System.out.println("Exception :" + this.isInterrupted());
                    e.printStackTrace();
                }
            }
        }
    }
}