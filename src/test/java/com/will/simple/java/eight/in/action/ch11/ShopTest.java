package com.will.simple.java.eight.in.action.ch11;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Shop shop = new Shop();
        Future<Double> priceAsync = shop.getPriceAsyncV3("19999");
        System.out.println(priceAsync.get());
    }

}