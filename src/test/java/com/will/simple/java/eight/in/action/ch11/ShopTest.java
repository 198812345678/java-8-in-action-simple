package com.will.simple.java.eight.in.action.ch11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Shop shop = new Shop();
        Future<Double> priceAsync = shop.getPriceAsyncV4("19999");
        System.out.println(priceAsync.get());
    }

    @Test
    public void test3() {
        Shop shop_1 = new Shop();
        Shop shop_2 = new Shop();
        Shop shop_3 = new Shop();
        Shop shop_4 = new Shop();
        Shop shop_5 = new Shop();

        List<Shop> list = Arrays.asList(shop_1, shop_2, shop_3, shop_4, shop_5);

        ShopPriceService service =  new ShopPriceService();
        long start = System.nanoTime();
        service.getAllShopPrice(list, "19999");
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        service.getAllShopPriceV2(list, "19999");
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        service.getAllShopPriceV3(list, "19999");
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        service.getAllShopPriceV4(list, "19999");
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void test4() {
        Shop shop_1 = new Shop();
        Shop shop_2 = new Shop();
        Shop shop_3 = new Shop();
        Shop shop_4 = new Shop();
        Shop shop_5 = new Shop();

        List<Shop> list = Arrays.asList(shop_1, shop_2, shop_3, shop_4, shop_5);

        ShopPriceService service =  new ShopPriceService();
        long start = System.nanoTime();
        service.getAllShopPriceV5(list, "19999");
        System.out.println(System.nanoTime() - start);

    }

}