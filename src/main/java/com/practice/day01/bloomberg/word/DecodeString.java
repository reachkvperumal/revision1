package com.practice.day01.bloomberg.word;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DecodeString {
    private static void decode(String text) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Character> characterList = text.chars()
                .mapToObj(i -> (char) i)
                .map(o -> {
                    if (Character.isDigit(o))
                        atomicInteger.getAndAdd(Character.getNumericValue(o));
                    return o;
                })
                .filter(Character::isAlphabetic)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(atomicInteger.get());
        System.out.println(characterList);
    }

    public static void main(String[] args) {
        decode("AC2BEW3");
    }
}
