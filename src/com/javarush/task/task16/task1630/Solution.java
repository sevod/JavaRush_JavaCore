package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName;
        private String fileContent = "";

        public void run(){
            try {
                //System.out.println("Начинаем чтение " + fileName); //
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                String line = "";
                while ((line = reader.readLine()) != null)
                    fileContent += line + " ";
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                //System.out.println("FileNotFoundException");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setFileName(String fullFileName){
            fileName = fullFileName;
        }

        public String getFileContent(){
            return fileContent;
        }

    }
}
