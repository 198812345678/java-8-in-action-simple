package com.will.simple.java.eight.in.action.ch1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Ch1Test {

    @Test
    public void test() {
        List<Apple> appleInventory = getApples();
        List<Apple> apples = FilteringApples.filterApples(appleInventory, Apple::isGreenApple);
        System.out.println(apples);

        apples = FilteringApples.filterApples(appleInventory, (Apple a) -> "greden".equals(a.getColor()));
        System.out.println(apples);

    }

    private List<Apple> getApples() {
        List<Apple> appleInventory = new ArrayList<Apple>();
        Apple apple1 = new Apple();
        apple1.setColor("red");
        Apple apple2 = new Apple();
        apple2.setColor("green");
        appleInventory.add(apple1);
        appleInventory.add(apple2);
        return appleInventory;
    }

    @Test
    public void test2() {
        List<Apple> appleInventory = getApples();
        Set<Apple> collect = appleInventory.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(toSet());
        System.out.println(collect);

        List<Apple> collect1 = appleInventory.parallelStream().filter((Apple a) -> "red".equals(a.getColor())).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
