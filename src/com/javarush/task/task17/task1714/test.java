package com.javarush.task.task17.task1714;

public class test {

    public static void main(String[] args) {

        Beach beach1 = new Beach("Beach1", 10, 5);
        Beach beach2 = new Beach("Beach2", 20, 3);

        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach2.compareTo(beach1));
    }
}
