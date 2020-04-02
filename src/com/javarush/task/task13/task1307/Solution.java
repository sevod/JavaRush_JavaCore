package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject<T> implements SimpleObject //допишите здесь ваш код
    {
        T name;

        public StringObject(T name){
            this.name = name;
        }

        public SimpleObject getInstance() {
            return new StringObject<String>("abc");
        }
    }
}