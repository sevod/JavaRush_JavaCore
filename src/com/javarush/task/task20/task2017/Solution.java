package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream)  {
        try {
            Object object = objectStream.readObject();
            return (A)object;
        } catch (Exception e) {
            try {
                B b = (B)objectStream.readObject();
                //b.B();
                return null;
            } catch (Exception e1){

            }
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}