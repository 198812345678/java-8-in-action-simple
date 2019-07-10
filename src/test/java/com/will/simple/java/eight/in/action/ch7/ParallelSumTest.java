package com.will.simple.java.eight.in.action.ch7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by will on 19/7/10.
 */
public class ParallelSumTest {

    @Test
    public void test_1() {
        long l = ParallelSum.parallelSum(10);
        System.out.println("===result:" + l + "==");
        ParallelSum.parallelSum(10);
    }

    @Test
    public void test_2() {
        long l = ParallelSum.serialStreamSum(10);
        System.out.println("===result:" + l + "==");
    }

    @Test
    public void test_3() {

        long time = measureSumPerf(ParallelSum::serialIterSum, 10000000);
        System.out.println("====serialIterSum time:" + time + "====");
        time = measureSumPerf(ParallelSum::serialStreamSum, 10000000);
        System.out.println("====tserialStreamSum ime:" + time + "====");
        time = measureSumPerf(ParallelSum::parallelSum, 10000000);
        System.out.println("====parallelSum time:" + time + "====");

        List<Long> list = new ArrayList<>(10000000);
        for (long i = 0; i < 10000000; i++) {
            list.add(i);
        }
        time = measureSumPerf_2(ParallelSum::serialStreamSum, list);
        System.out.println("====serialStreamSum time:" + time + "====");

        time = measureSumPerf_2(ParallelSum::parallelSum, list);
        System.out.println("====parallelSum time:" + time + "====");

        time = measureSumPerf(ParallelSum::parallelLongStreamSum, 10000000);
        System.out.println("====parallelLongStreamSum time:" + time + "====");


    }

    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public long measureSumPerf_2(Function<List<Long>, Long> adder, List<Long> list) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(list);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }
}