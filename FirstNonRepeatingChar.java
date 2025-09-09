package com.demo.java8;

import javax.swing.text.html.Option;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println();
        String s = "aabbcc"; //aabbccddeffg aabbcc programming
        s.chars().mapToObj(c->(char)c).
                collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).
                entrySet().stream().filter(e->e.getValue()==1).findFirst().
                ifPresentOrElse((e)->System.out.println(e),()-> System.out.println("Non Repeating chars are not present"));
    }
}
