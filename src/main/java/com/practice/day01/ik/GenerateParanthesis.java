package com.practice.day01.ik;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    static void compute(List<String> result, String cur, int open, int close, int max) {

        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        } else {
            if (open < max)
                compute(result, cur + "(", open + 1, close, max);

            if (close < open)
                compute(result, cur + ")", open, close + 1, max);
        }
    }

    static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        compute(result, "", 0, 0, n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(3));
    }

}


