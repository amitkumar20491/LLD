package main.java.com.lld.producerconsumer.buffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBufferSemaphore<T> implements Buffer<T>{
    private final Queue<T> queue = new LinkedList<>();
    private int capacity;
    private Semaphore emptySlots;
    private Semaphore fullSlots;
    private final Lock lock = new ReentrantLock();

    public BoundedBufferSemaphore(int capacity){
        this.capacity = capacity;
        emptySlots = new Semaphore(capacity);
        fullSlots = new Semaphore(0);
    }

    public void put(T item) throws InterruptedException{
        emptySlots.acquire();
        lock.lock();

        try{
            queue.add(item);
        }finally{
            lock.unlock();
        }

        fullSlots.release();
    }

    public T get() throws InterruptedException{
        fullSlots.acquire();
        lock.lock();
        T item;
        try{
            item = queue.poll();
        }finally{
            lock.unlock();
        }
        emptySlots.release();
        return item;
    }
}
