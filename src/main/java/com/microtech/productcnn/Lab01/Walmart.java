package com.microtech.productcnn.Lab01;

import java.util.Arrays;
import java.util.List;

public class Walmart {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(50,80,71,14,100,809,9,71);
        List<Integer> evenNumbers = numbers.stream().filter(n->n%2==0).map(m->m*2).toList();
        System.out.println(evenNumbers);
    }
}
