package com.will.simple.java.eight.in.action.ch2;

import com.will.simple.java.eight.in.action.FounctionalInterface;
import org.junit.Test;

public class IdefTest {

    /**
     * 匿名内部类在定义局部变量时会与上下文相互影响
     */
    @Test
    public void test() {
        Integer i = new Integer(1);
        Integer ii = new Integer(2);
        FounctionalInterface founctionalInterface = new FounctionalInterface() {
            @Override
            public void doSomething(Integer i) {
//                Integer ii = new Integer(3);
                System.out.println(ii);
            }
        };
        founctionalInterface.doSomething(ii);
    }
}