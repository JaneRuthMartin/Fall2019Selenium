package com.automation.tests.Practice;

public class deneme {
    public static void main(String[] args) {
        /*int a = 129;
        byte b = (byte) a;
        System.out.print(b);*/

       /* //String a = "interned String";
        String b = new String ("interned String");
        String c = b.intern();
        System.out.println(b==c);*/

        String a = "interned String";
        String b = new String ("interned String").intern();
        String c = b.intern();
        System.out.println(b==c);
        System.out.println(a==c);
        System.out.println(b==a); // true
    }
}
