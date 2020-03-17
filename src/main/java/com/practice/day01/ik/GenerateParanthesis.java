package com.practice.day01.ik;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {


    static void compute(List<String> result, String cur, int start, int end, int max) {
        if (max * 2 == cur.length()) {
            result.add(cur);
            return;
        } else {
            if (start < max)
                compute(result, cur + "(", start + 1, end, max);

            if (end < start)
                compute(result, cur + ")", start, end + 1, max);
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


