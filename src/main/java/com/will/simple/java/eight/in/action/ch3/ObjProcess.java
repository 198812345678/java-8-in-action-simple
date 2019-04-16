package com.will.simple.java.eight.in.action.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ObjProcess<T, R> {

    public List<R> useFuntion(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T integer : list) {
            result.add(function.apply(integer));
        }
        return result;
    }

    public List<T> usePredicate(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public void useConsumer(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
