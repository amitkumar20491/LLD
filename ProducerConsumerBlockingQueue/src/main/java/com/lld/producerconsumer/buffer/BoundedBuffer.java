package main.java.com.lld.producerconsumer.buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BoundedBuffer<T> implements Buffer<T>{
    private final BlockingQueue<T> queue;

    public BoundedBuffer(int capacity){
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void put(T item) throws InterruptedException{
        queue.put(item);
    }

    public T get() throws InterruptedException{
        return queue.take();
    }
}
