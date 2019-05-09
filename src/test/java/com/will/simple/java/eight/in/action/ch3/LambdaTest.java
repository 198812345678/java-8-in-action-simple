package com.will.simple.java.eight.in.action.ch3;

import com.will.simple.java.eight.in.action.FounctionalInterface;
import com.will.simple.java.eight.in.action.NotFounctionalInterface;
import com.will.simple.java.eight.in.action.ch1.Apple;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    private long instanceL = 0L;
    private static long staticL = 0L;

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

    @Test
    public void test2() throws Exception{
        //将逻辑划分为1.打开文件；2.读取文件（或者其他操作）；3.close文件

        /**
         * 定义FunctionalInterface
         * @see BufferedReaderFileProcess#process(java.io.BufferedReader)
         */

        /**
         * FunctionalInterface作为入参实现方法
         * @see FileProcessor#processFile(com.will.simple.java.eight.in.action.ch3.BufferedReaderFileProcess)
         */

        /**
         * 使用的时候以lambda形式传入参
         */
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFile((BufferedReader r) -> {
            try {
                return r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });

        fileProcessor.processFile((BufferedReader r) -> {
            try {
                return r.readLine() + r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });

    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3);

        ObjProcess<Integer, String> objProcess = new ObjProcess();
        List<Integer> integers = objProcess.usePredicate(list, (Integer i) -> i == 1);
        objProcess.useConsumer(list, (Integer i) -> {});
        List<String> strings = objProcess.useFuntion(list, (Integer i) -> String.valueOf(i));

    }

    @Test
    public void test4() {
        doSomething(i -> System.out.println(i.intValue()), 1);
    }

    @Test
    public void test5() {
        long l = 0L;
//        l = 1L;
        doSomething(i -> System.out.println(l), 1);
//        l = 0;

        /**instance variables*/
        doSomething(i -> System.out.println(instanceL), 1);
        instanceL = 9;

        /**static variables*/
        doSomething(i -> System.out.println(staticL), 1);
        staticL = 0;
    }

    @Test
    public void test6() {
        long l = 0;
        doSomething(new FounctionalInterface() {
            @Override
            public void doSomething(Integer i) {
                System.out.println(i);
            }
        }, 1);
//        l = 9;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(l);
            }
        };

//        l = 0;

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
