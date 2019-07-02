package com.will.simple.java.eight.in.action.ch3;

import java.util.function.Function;
import java.util.function.IntFunction;

public class LambdaMain {

    public static void main(String[] args) {
        IntFunction<Integer> function = i -> i;
        function.apply(1);
    }
}
