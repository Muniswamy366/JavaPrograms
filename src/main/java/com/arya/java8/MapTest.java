package com.arya.java8;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("muni", 1);
        map.put("swamy", 2);
        map.put("palla", 3);
        map.put("arya", 4);

        map.entrySet().removeIf(e -> "muni".equals(e.getKey()));
        System.out.println(map);

    }
}
