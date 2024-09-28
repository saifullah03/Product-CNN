package com.microtech.productcnn.Lab01;

import java.util.ArrayList;

public class MethodAndConstructorReference {
    public static void main(String[] args) {
        //String s = "Hello";


        ArrayList<String> names= new ArrayList<>();
        names.add("Jhon");
        names.add("Maria");
        names.add("Mubin");
        names.add("Masuk");
        names.add("Dovela");

        names.stream().map(String::toUpperCase).forEach(s-> System.out.println(s));
    }
}
