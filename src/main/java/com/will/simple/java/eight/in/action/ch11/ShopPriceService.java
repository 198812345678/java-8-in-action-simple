package com.will.simple.java.eight.in.action.ch11;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ShopPriceService {


    public List<Double> getAllShopPrice(List<Shop> shops, String product) {

        return shops.parallelStream()
                .map(shop -> shop.getPrice(product))
                .collect(Collectors.toList());

    }

    public List<Double> getAllShopPriceV2(List<Shop> shops, String product) {

        return shops.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.join())
                .collect(Collectors.toList());

    }


    public List<Double> getAllShopPriceV3(List<Shop> shops, String product) {

        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .collect(Collectors.toList());

    }

    public List<Double> getAllShopPriceV4(List<Shop> shops, String product) {

        List<CompletableFuture<Double>> futures = shops.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    public List<Double> getAllShopPriceV5(List<Shop> shops, String product) {
        Executor executorService = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "ShopService getAllShopPriceV5 thread");
                thread.setDaemon(true);
                return thread;
            }
        });


        List<CompletableFuture<Double>> futures = shops.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executorService))
                .collect(Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

}


