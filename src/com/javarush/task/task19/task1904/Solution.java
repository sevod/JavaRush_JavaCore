package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws ParseException {
//        String inputString = "Иванов Иван Иванович 31 12 1950";
//        String[] inputData = inputString.split(" ");
//        String strDate = inputData[3] + "/" + inputData[4] + "/" + inputData[5];
//        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
//        Person person = new Person(inputData[1], inputData[2], inputData[0], data);
//        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String inputString = fileScanner.nextLine();
            String[] inputData = inputString.split(" ");
            String strDate = inputData[3] + "/" + inputData[4] + "/" + inputData[5];
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
            Person person = new Person(inputData[1], inputData[2], inputData[0], data);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
