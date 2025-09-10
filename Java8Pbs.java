package com.demo.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Pbs {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("find the longest word");
        List<String> stringList = Arrays.asList("java", "springboot", "microservices", "api", "cloud");
        stringList.stream().distinct().max(Comparator.comparingInt(String::length)).
                ifPresentOrElse((e) -> System.out.println(e), () -> System.out.println("No elements are present"));

        System.out.println("find all even numbers, square them, and collect into a new list");
        List<Integer> list = Arrays.asList(1,2,34,7,99,4);
        List<Integer> i =  list.stream().filter(a->a%2==0).map(a->(int)Math.pow(a,2)).collect(Collectors.toList());
        System.out.println(i);
    }
}