package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        boolean first = true;
        for (Map.Entry<String, String> pair: runtimeStorage.entrySet()) {
            if (!first)
                outputStream.write("\r\n".getBytes());
            String key = pair.getKey();
            key = key.replace(" ", "\\ ");
            outputStream.write((key + "=" + pair.getValue()).getBytes());
            first = false;
        }
        outputStream.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry pair: properties.entrySet()) {
            runtimeStorage.put((String)pair.getKey(), (String)pair.getValue());
        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        while (bufferedReader.ready()){
//            String str = bufferedReader.readLine();
//            if (str.contains("#"))
//                continue;
//            if (str.contains("!"))
//                continue;
//            str = str.replace("\\ ", "");
//            str = str.replace("\\:", ":");
//            String []aStr = str.split("=");
//
//            runtimeStorage.put(aStr[0], aStr[1]);
//        }
//        bufferedReader.close();
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             FileInputStream fos = new FileInputStream(reader.readLine())) {
//            load(fos);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String fileNameRead = "c:/test/1";
        String fileNameWrite = "c:/test/2";

        FileInputStream fileInputStream = new FileInputStream(fileNameRead);
        load(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameWrite);
        save(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();

        System.out.println(runtimeStorage);
    }
}
