package com.microtech.productcnn.Lab01;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void print(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        List<String> students = Arrays.asList("Java","Phython","JavaScript");
        students.forEach(Test::print);

    }
}
