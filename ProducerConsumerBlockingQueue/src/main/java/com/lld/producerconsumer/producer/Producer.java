package main.java.com.lld.producerconsumer.producer;

import java.util.function.Supplier;

import main.java.com.lld.producerconsumer.buffer.Buffer;

public class Producer<T> implements Runnable{
    private final Buffer<T> buffer;
    private final Supplier<T> supplier;

    public Producer(Buffer<T> buffer, Supplier<T> supplier){
        this.buffer = buffer;
        this.supplier = supplier;
    }

    public void run(){
        while(true){
            try {
                T item = supplier.get();
                buffer.put(item);
                System.out.println(Thread.currentThread().getName() + " Produced: " + item);
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
