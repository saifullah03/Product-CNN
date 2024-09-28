package com.microtech.productcnn.Lab01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
//        List<Integer> lenghts = new ArrayList<>();
        names.add("Jhons");
        names.add("Jane Jane");
        names.add("Jack Be");
        names.add("Java Language");

//        for(String name:names){
//          int i = name.length();
//          lenghts.add(i);
//        }

        //System.out.println(lenghts);


        System.out.println(names.stream().map(String::length).toList());
    }
}
