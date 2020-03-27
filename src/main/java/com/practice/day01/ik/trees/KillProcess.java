package com.practice.day01.ik.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KillProcess {

    static void getAllChildren(Map<Integer, List<Integer>> map, List<Integer> l, int kill) {
        if (map.containsKey(kill)) {
            for (int id : map.get(kill)) {
                l.add(id);
                getAllChildren(map, l, id);
            }
        }
    }

    static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(kill);
        getAllChildren(map, l, kill);
        return l;
    }

    static List<Integer> getData(int[] nums) {
        return IntStream.of(nums).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] pid = {1, 3, 10, 5};
        int[] ppid = {3, 0, 5, 3};
        System.out.println(killProcess(getData(pid), getData(ppid), 5));
    }
}
