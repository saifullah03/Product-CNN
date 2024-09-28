package com.microtech.productcnn.Lab02;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jhon","Maria","Dovela");

        names.stream().map(Student::new).forEach(s-> System.out.println(s));

    }
}
