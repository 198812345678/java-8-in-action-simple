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
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {

    private long instanceL = 0L;
    private static long staticL = 0L;

    public static int fdd(int i) {
        return i;
    }

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

    @Test
    public void test7() {
        doAdd(new NotFounctionalInterface() {
            @Override
            public void doSomething(Integer i) {

            }

            @Override
            public void add(Integer i, Integer ii) {

            }
        }, 1, 2);
    }

    @Test
    public void test8() {
        Consumer<Integer> consumer = (i) -> System.out.println(i);
        consumer.accept(4);
        System.out.println(consumer);
    }

    @Test
    public void test9() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        }).start();

        new Thread(() -> {/**do something*/}).start();
    }

    @Test
    public void test10() {
        final Integer locI = 0;
        Function<Integer, Boolean> function1 = (Integer i) -> i == locI;

        Integer locII = 0;
        Function<Integer, Boolean> function2 = (Integer i) -> i == locII;

        Integer locIII = 0;
        Function<Integer, Boolean> function3 = (Integer i) -> i == locIII;
//        locIII = 9;


        Predicate<Integer> predicate = (Integer i) -> i == null;

        Consumer<List<Integer>> consumer = (List<Integer> list) -> list.add(2);
    }

    @Test
    public void test11() {
        BiFunction<Integer, String, Integer> biFunction = (i, s) -> i.intValue();

//        biFunction = Integer::intValue;
//        biFunction = Integer::valueOf;

        Function<Integer, Integer> function = (i) -> i.intValue();
        function = Integer::valueOf;//①
        function = Integer::intValue;//②

        Integer ii = 0;
        function = (i) -> ii.compareTo(i);
        function = ii::compareTo;//③
        function = Integer::new;
    }

    @Test
    public void test12() {
        Comparator.comparing((Integer i) -> i.intValue());
    }

    @Test
    public void test13() {
        Function<Integer, Integer> f = Integer::new;
        Function<Integer, Integer> f2 = (i) -> new Integer(i);
        Consumer<Integer> consumer = (Integer i) -> i += f.apply(i);
    }

    @Test
    public void test14() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.sort(Comparator.comparing((Integer i) -> i).reversed().thenComparing((Integer i) -> i * -1));

        List<Apple> apples = Arrays.asList();
        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));

        System.out.println(list);

        Predicate<Integer> predicate = (i) -> i == 1;
        predicate = predicate.or((i) -> i == 2).and((i) -> i == 2);
        predicate.test(1);//false
        predicate.test(2);//true


        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        f.compose(g).apply(1);//f(g(1)) = 3
        f.andThen(g).apply(1);//g(f(1)) = 4
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
