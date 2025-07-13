package main.java.com.lld.producerconsumer.buffer;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBufferWaitNotify<T> implements Buffer<T>{
    private final Queue<T> queue = new LinkedList<>();
    private int capacity;

    public BoundedBufferWaitNotify(int capacity){
        this.capacity = capacity;
    }

    public void put(T item) throws InterruptedException{
        synchronized(queue){
            while(queue.size() == capacity){
                queue.wait();
            }
            queue.add(item);
            queue.notifyAll();
        }
    }

    public T get() throws InterruptedException{
        synchronized(queue){
            while(queue.isEmpty()){
                queue.wait();
            }
            T item = queue.poll();
            queue.notifyAll();
            return item;
        }
    }
}
