package com.practice.day01.ik;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortCharacter {

    static List<Character> sort(List<Character> arr) {
        int[] aux = new int[128];
        for (Character c : arr)
            aux[c]++;

        System.out.println(Arrays.toString(aux));
        arr.clear();
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < aux[i]; j++)
                arr.add((char) i);
        }
        return arr;
    }

    public static void main(String[] args) {

        List<Character> list = Stream.of('a', 'z', 'i', '#', '&', 'l', 'c', '(', 'L', 'u', '$', 'e', '6', 'o', '2', 'i', ')', 'D', 'F', 's', 'L').collect(Collectors.toList());
        System.out.println(Arrays.asList(list));
        System.out.println(sort(list));


    }

}
