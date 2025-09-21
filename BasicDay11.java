package com.demo.model.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicDay11 {
    public static void main(String[] args) {
        String s = "Hello World";
        String rs = Stream.of(s.split(" ")).map((l)->new StringBuilder(l).reverse()).collect(Collectors.joining(" "));
        System.out.println(rs);

        int num = 123;
        int sum = String.valueOf(num).chars().map(Character::getNumericValue).sum();
        System.out.println(sum);

        List<Integer> nums = Arrays.asList(1,45,86,29,17,66);
        nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
    }
}
