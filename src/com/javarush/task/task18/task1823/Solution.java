package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String str = reader.readLine();

            if (str.equals("exit"))
                break;
            else {
                Thread readThread = new ReadThread(str);
                readThread.start();
            }
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            Map<Integer, Integer> localMap = new HashMap<>();
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0){
                    int key = fileInputStream.read();
                    if (!localMap.containsKey(key))
                        localMap.put(key, 1);
                    else
                        localMap.put(key, localMap.get(key) + 1);
                }
                fileInputStream.close();

                int maxValue = 0;
                int maxKey = 0;
                for (Map.Entry<Integer, Integer> entry: localMap.entrySet()) {
                    if (maxValue < entry.getValue()){
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                resultMap.put(fileName, maxKey);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
