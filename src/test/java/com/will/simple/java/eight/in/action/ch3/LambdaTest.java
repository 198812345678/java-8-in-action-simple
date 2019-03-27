package com.will.simple.java.eight.in.action.ch3;

import com.will.simple.java.eight.in.action.FounctionalInterface;
import com.will.simple.java.eight.in.action.NotFounctionalInterface;
import org.junit.Test;

public class LambdaTest {

    @Test
    public void test() {
        doSomething((Integer i) -> System.out.println(i), 1);//包在里面的要是完整的语句，表达式不能用{}
        doSomething((Integer i) -> {System.out.println(i);}, 1);
    }

    @Test
    public void test1() {
        /**
         * 只能是functional interface的地方用
         */
//        doAdd((Integer i, Integer ii) -> i += ii, 2, 3);
//        print(() -> 2);
    }

    private void doSomething(FounctionalInterface founctionalInterface, Integer i) {
        founctionalInterface.doSomething(i);
    }

    private void print(Integer integer) {
        System.out.println(integer);
    }

    private void doAdd(NotFounctionalInterface notFounctionalInterface, Integer i, Integer ii) {
        notFounctionalInterface.add(i, ii);
    }

    private FounctionalInterface buildFounctionalInterface() {
        return Integer -> System.out.println();
    }
}
