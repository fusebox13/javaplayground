package com.fuseworks.labs.playground.sandbox;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class SandboxTest {



    @Before
    public void setUp() { }


    @Test
    public void testThreadPool() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        CompletableFuture<Integer> c1 = CompletableFuture.completedFuture(1);
        CompletableFuture<Integer> c2 = CompletableFuture.completedFuture(2);
        CompletableFuture<Integer> c3 = CompletableFuture.completedFuture(3);

        c1 = c1.thenApplyAsync(x -> {
            try {
                Assertions.assertThat(executor.getPoolSize()).isEqualTo(1);
                Assertions.assertThat(executor.getQueue().size()).isEqualTo(0);
                System.out.println("c1 - Going to sleep: " + OffsetDateTime.now().toString());
                Thread.sleep(3000);
                System.out.println("c1 - Waking up: " + OffsetDateTime.now().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x;
        }, executor);

        c2 = c2.thenApplyAsync(x -> {
            try {
                Assertions.assertThat(executor.getPoolSize()).isEqualTo(2);
                Assertions.assertThat(executor.getQueue().size()).isEqualTo(0);
                System.out.println("c2 - Going to sleep: " + OffsetDateTime.now().toString());
                Thread.sleep(2000);
                System.out.println("c2 - Waking up: " + OffsetDateTime.now().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x;
        }, executor);

        c3 = c3.thenApplyAsync(x -> {
            try {
                Assertions.assertThat(executor.getPoolSize()).isEqualTo(3);
                Assertions.assertThat(executor.getQueue().size()).isEqualTo(0);
                System.out.println("c3 - Going to sleep: " + OffsetDateTime.now().toString());
                Thread.sleep(1000);
                System.out.println("c3 - Waking up: " + OffsetDateTime.now().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return x;
        }, executor);

        Assertions.assertThat(executor.getPoolSize()).isEqualTo(3);
        Assertions.assertThat(executor.getQueue().size()).isEqualTo(0);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(c1, c2, c3);

        allFutures.get();

        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
    }
}