package com.javarush.task.task20.task2014;

import com.sun.corba.se.pept.encoding.OutputObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution savedObject = new Solution(15);
        FileOutputStream fileOutputStream = new FileOutputStream("c:/test/1");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedObject);

        FileInputStream fileInputStream = new FileInputStream("c:/test/1");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution loadedObject = (Solution) objectInputStream.readObject();

        System.out.println(savedObject.string.equals(loadedObject.string));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature)  {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
