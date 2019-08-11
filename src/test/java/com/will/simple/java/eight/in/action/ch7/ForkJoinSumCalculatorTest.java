package com.will.simple.java.eight.in.action.ch7;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinSumCalculatorTest {

    @Test
    public void test() {
        long[] numbers = LongStream.rangeClosed(1, 10_000_000).toArray();
        ForkJoinSumCalculator calculator = new ForkJoinSumCalculator(numbers);
        Long invoke = new ForkJoinPool().invoke(calculator);
        System.out.println(invoke);
    }
}
