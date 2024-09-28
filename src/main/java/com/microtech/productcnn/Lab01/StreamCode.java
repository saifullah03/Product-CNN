package com.microtech.productcnn.Lab01;

import java.util.ArrayList;

public class StreamCode {
    public static void main(String[] args) {
        ArrayList <String> names= new ArrayList<>();
        names.add("Jhon");
        names.add("Maria");
        names.add("Mubin");
        names.add("Masuk");
        names.add("Dovela");

//        System.out.println(names);
//        for(String s:names){
//            System.out.println(s);
//        }

//        names.stream().forEach(s -> System.out.println(s));
       // names.stream().filter(name->name.startsWith("M")).forEach(s -> System.out.println(s));
       // names.stream().map(name->name.toUpperCase()).forEach(s -> System.out.println(s));
        names.stream().sorted().skip(3).forEach(s -> System.out.println(s));

    }
}
