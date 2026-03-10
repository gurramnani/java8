package com.demo;

import java.util.concurrent.CompletableFuture;

public class CompletableFuture1 {
    public static void main(String[] args) {
        /*
        CompletableFuture is a class in Java 8 used to perform asynchronous (non-blocking) computations.
        It allows a task to run in another thread, and the main thread can continue execution without waiting.
        CompletableFuture is used to run tasks asynchronously and process the result when the task completes.

        Before Java 8 we had:
Future
ExecutorService

But Future had limitations:

Cannot chain tasks
Cannot combine multiple tasks
Hard error handling
CompletableFuture solves these problems.
         */


        System.out.println("Completable future example Demo");
        System.out.println(Thread.currentThread());

        /*
        runAsync() : Used when no return value is needed.
         */
        CompletableFuture.runAsync(()-> {
            System.out.println("running using runAsync method");
            System.out.println(Thread.currentThread());
        });


        /*
        supplyAsync(): Used when a result is returned.
         */
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->10);
        System.out.println(future.join());

        /*
         Chaining Tasks
                       thenApply(): Transforms result, used when the function returns a normal value.
         */
        CompletableFuture<Integer> futureChaning = CompletableFuture.supplyAsync(()->10).thenApply(n->n*2);
        System.out.println(futureChaning.join());

        /*
        Consuming Result
                        thenAccept() : Consumes result but returns nothing.
         */
        CompletableFuture.supplyAsync(()->22).thenAccept(result-> System.out.println(result));

        /*
        Combining Two Futures: thenCombine()
         */
        CompletableFuture<Integer> future2= CompletableFuture.supplyAsync(()->11);
        CompletableFuture<Integer> future3= CompletableFuture.supplyAsync(()->16);
        CompletableFuture<Integer> futureCombine = future2.thenCombine(future3,(a,b)->a+b);
        System.out.println(futureCombine.join());

        /*
        thenCompose(): Used when the function returns another CompletableFuture.
         */
        CompletableFuture<Integer> futur =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenCompose(n ->
                                CompletableFuture.supplyAsync(() -> n * 2)
                        );
        System.out.println(futur.join());

        System.out.println("Fetch user name asynchronously, convert it to upper case and print the result");
        CompletableFuture.supplyAsync(()->"Ram").thenApply(a->a.toUpperCase()).thenAccept(System.out::println);
    }
}
