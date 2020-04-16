package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import com.sun.org.apache.bcel.internal.Constants;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        String countryPhoneCode = ((Integer)38).toString();
//        int pN = 501234567;
//        String phoneNumber =  String.valueOf(pN);
//        while (phoneNumber.length() != 10){
//            phoneNumber = "0" + phoneNumber;
//        }
//        String endPN = "+" + 38 + "(" + phoneNumber.substring(0,3) + ")" + phoneNumber.substring(3,6)
//                + "-" + phoneNumber.substring(6,8) + "-" +phoneNumber.substring(8,10);
//        System.out.println(endPN);
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter (IncomeData incomeData){
            this.data = incomeData;
        }

        public String getCountryCode() {
            return data.getCountryCode();
        }

        public String getCompany() {
            return data.getCompany();
        }

        public String getContactFirstName() {
            return data.getContactFirstName();
        }

        public String getContactLastName() {
            return data.getContactLastName();
        }

        public int getCountryPhoneCode() {
            return data.getCountryPhoneCode();
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
//            String countryPhoneCode = ((Integer)data.getCountryPhoneCode()).toString();
//            int pN = data.getPhoneNumber();
//            String firstNumber = ((Integer)(pN/10000000)).toString();
//            while (firstNumber.length() <3)
//                firstNumber = "0" + firstNumber;
//            String phoneNumber = "(" + firstNumber + ")" + (pN%10000000)/10000 + "-" + (pN%10000)/100 + "-" + pN%100;
//            return("+" + countryPhoneCode + phoneNumber);


            int pN = data.getPhoneNumber();
            String phoneNumber =  String.valueOf(pN);
            while (phoneNumber.length() != 10){
                phoneNumber = "0" + phoneNumber;
            }
            String endPN = "+" + data.getCountryPhoneCode() + "(" + phoneNumber.substring(0,3) + ")" + phoneNumber.substring(3,6)
                    + "-" + phoneNumber.substring(6,8) + "-" +phoneNumber.substring(8,10);
            return endPN;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String countryCode = data.getCountryCode();
            return countries.get(countryCode);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}