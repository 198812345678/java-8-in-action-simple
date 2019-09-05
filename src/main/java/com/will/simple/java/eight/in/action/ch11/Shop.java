package com.will.simple.java.eight.in.action.ch11;

import java.util.Random;
import java.util.concurrent.*;

import static com.will.simple.java.eight.in.action.ch11.Delay.delay;

public class Shop {

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double getPriceException(String product) {
        throw new RuntimeException("this is an exception");
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> getPriceException(product));
    }


    public Future<Double> getPriceAsyncV2(String product) {
        CompletableFuture future = new CompletableFuture();
        new Thread(() -> {
            double price = getPriceException(product);
            future.complete(price);
        });
        return future;
    }

    public Future<Double> getPriceAsyncV3(String product) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        return executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return getPriceException(product);
            }
        });
    }
}
