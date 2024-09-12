package org.apache.dubbo.springboot.demo;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return "result1";
        }, executor);

        CompletableFuture<String> cf2 = cf1.thenApply(result1 -> {
            return "result2";
        });

        CompletableFuture<String> cf3 = cf2.thenApply(result2 -> {
            return "result3";
        });

        System.in.read();
    }
}
