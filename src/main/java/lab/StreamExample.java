package lab;

import java.util.ArrayList;

public class StreamExample {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        //  ArrayList<Integer> length = new ArrayList<>();

        names.add("Barak");
        names.add("Baiden");
        names.add("Jhone");
        names.add("Maria");
        names.add("Java");

        names.stream()
                .filter(n -> n.startsWith("B"))
                .map(s -> s + " is selectd")
                .forEach(n -> System.out.println(n));


    }
}
