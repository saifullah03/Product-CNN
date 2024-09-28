package com.microtech.productcnn.Lab01;

public class MethodReturn {

    public static void main(String[] args) {
      int i =  getString("Hello Java");
        System.out.println(i);
    }

    public static int getString(String s){
       return s.length();
    }
}
