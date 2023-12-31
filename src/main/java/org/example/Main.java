package org.example;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        final List<Integer> numbers = IntStream.range(1, 10).boxed().toList();
        System.out.println(numbers);
    }
}