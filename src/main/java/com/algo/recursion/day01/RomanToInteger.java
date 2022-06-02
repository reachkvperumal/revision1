package com.algo.recursion.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<String,Integer> LOOKUP = new HashMap<>(){{
        put("M",1000);
        put("D",500);
        put("C",100);
        put("L",50);
        put("X",10);
        put("V",5);
    }};

    public static void main(String[] args) {
        String[] str = {"kv","KV","Avantika","aVantika","Shanmuga","shanmuga","400","1"};
        Arrays.sort(str);
        Arrays.asList(str).forEach(System.out::println);

    }

}
