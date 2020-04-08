package com.automation.tests.StudyTogether;

    public class Practice {

        // Strings and Primitive Type and Casting
        // byte, char, short, int, long, float, double, boolean
        // int From +2,147,483,647 to -2,147,483,648
        // int is 32 bits
        // float From 3.402,823,5 E+38 to 1.4 E-45
        // float is 32
        // 3402823500000000000000000000000000

        // double is larger than integer

        public static void main(String[] args) {

//        int intValue = 5;
////        double doubleValue = 5;
////        int doubleValueToInt = (int) doubleValue;
////        System.out.println("Int value to Double (small to big): " + doubleValue);
////        System.out.println("Double to int value (big to small): " + doubleValueToInt);
////        byte byteValue = 10;
////        short shortValue = byteValue;
////        byte newByteValue = (byte)shortValue;
////        System.out.println(newByteValue);

//        int a = 2000;
//        byte b = (byte) a;
//        System.out.println(b);
            // Muge says "127" positive, and Mike says "127" negative
            // byte range is from -128 to +127
            // when it overflows, it switches negative/positive
            // -129 -128 = -1 ...
            // -128 -127 -126 -125.......+125 +126 +127

//        Byte byteValue = b;
//        System.out.println("Byte as an Object: " + byteValue);
//        Byte byteValueFromInt = (byte) a;
//        // combined wrapper class with down casting
//        Integer intValue = a;
//        System.out.println("Integer max: " + Integer.MAX_VALUE + " Integer minimum: " + Integer.MIN_VALUE);

            // you have 200 cents
            // how many dimes you can get
            // how many quarter you can get
            // how many nickels you can
            // how many dimes you can get

            int cent = 200;

            //you have purchased a candle for 0.74 cent, what would be your remainder?

            cent -=74; //126 cent after spending 74 cent for candle
            int quarter       =  cent/25; //126/25---> 5 , 1 is remaining
            int penny         =  cent%25; //126/25  -->5 , 1 is remaining
            System.out.println(quarter);
            System.out.println(penny);

            //now i want to try to calculate dime for same money i got after purchase
            // in dime

            int dime = cent/10; //---> 126/10 ---> 12 and remainder is 6

            // how much penny i have after getting dime 126 % 10 -->> 6
            // creating new penny2 for not mixing with previous one

            int penny2 = cent % 10;  ///---->> 6
            System.out.println(dime);
            System.out.println(penny2);

//        System.out.println("Using parseInt: " + Integer.parseInt("512"));
//        System.out.println("Using valueOf: " + Integer.valueOf("512"));

        int a = 139;
        byte b = (byte) a;
        System.out.println(b);
        }
    }

