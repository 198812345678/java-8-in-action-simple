package com.will.simple.java.eight.in.action.mapTest;

import com.alibaba.fastjson.JSON;
import com.will.simple.java.eight.in.action.ch1.Apple;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void test1() {
        Map<String, Apple> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.compute("a", (key, value) -> {
                if (value == null) {
                    value = new Apple();
                    value.setWeight(1);
                } else {
                    value.setWeight(value.getWeight() + 1);
                }

                return value;
            });
            System.out.println(JSON.toJSONString(map));
        }

    }
}
