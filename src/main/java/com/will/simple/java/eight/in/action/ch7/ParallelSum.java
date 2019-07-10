package com.will.simple.java.eight.in.action.ch7;

import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by will on 19/7/10.
 */
public class ParallelSum {

    public static long parallelSum(long n) {
        return Stream.iterate(0L, i -> i + 1).limit(n).parallel().reduce(0L, (a, b) -> {
//            System.out.println(Thread.currentThread().getName());
            return a + b;
        });
    }

    public static long parallelLongStreamSum(long n) {
        return LongStream.rangeClosed(0, n).parallel().reduce(0L, (a, b) -> {
//            System.out.println(Thread.currentThread().getName());
            return a + b;
        });
    }

    public static long parallelSum(List<Long> list) {
        return list.stream().parallel().reduce(0L, (a, b) -> {
//            System.out.println(Thread.currentThread().getName());
            return a + b;
        });
    }

    public static long serialStreamSum(long n) {
        return Stream.iterate(0L, i -> i + 1).limit(n).parallel().sequential().reduce(0L, (a, b) -> {
//            System.out.println(Thread.currentThread().getName());
            return a + b;
        });
    }

    public static long serialStreamSum(List<Long> list) {
        return list.stream().reduce(0L, (a, b) -> {
//            System.out.println(Thread.currentThread().getName());
            return a + b;
        });
    }

    public static long serialIterSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
