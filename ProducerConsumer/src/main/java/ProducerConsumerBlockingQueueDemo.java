package main.java;

import main.java.com.lld.producerconsumer.buffer.BoundedBuffer;
import main.java.com.lld.producerconsumer.buffer.Buffer;
import main.java.com.lld.producerconsumer.consumer.Consumer;
import main.java.com.lld.producerconsumer.producer.Producer;

public class ProducerConsumerBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        Buffer<Integer> buffer = new BoundedBuffer<>(5);

        Thread p1 = new Thread(new Producer<>(buffer , () -> (int) (Math.random() * 100)), "Producer-1");
        Thread p2 = new Thread(new Producer<>(buffer , () -> (int) (Math.random() * 100)), "Producer-2");
        Thread c1 = new Thread(new Consumer<>(buffer) , "Consumer-1");
        Thread c2 = new Thread(new Consumer<>(buffer), "Consumer-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
