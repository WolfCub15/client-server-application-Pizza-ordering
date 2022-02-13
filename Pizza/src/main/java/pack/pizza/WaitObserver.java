/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.pizza;

import io.grpc.stub.StreamObserver;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
/**
 *
 * @author Nastya
 */
public class WaitObserver<T> implements StreamObserver<T> {
    private final CountDownLatch countDownLatch;
    private final Consumer<T> consumer;
    
    public WaitObserver(CountDownLatch countDownLatch, Consumer<T> consumer){
        this.countDownLatch = countDownLatch;
        this.consumer = consumer;
    }
    @Override
    public void onNext(T t) {
        consumer.accept(t);
    }

    public CountDownLatch getLatch() {
        return countDownLatch;
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
    @Override
    public void onCompleted() {
        countDownLatch.countDown();
    }
}

