package com.example.lamp01;

public class MyClass {
    public static void main(String[] args) {
        User u1=new User("xiaoming");
        User u2=new User("daming");
        u1.connectwith(u2);
        u1.activity("emotion");
        u2.activity("voice message");
        System.out.println(u1.checkHistory());
        System.out.println(u2.checkHistory());
    }
}
