package com.will.simple.java.eight.in.action.ch6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorTest {

    @Test
    public void test1() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.stream().collect(Collectors.toList());
    }
}
