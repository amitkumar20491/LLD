package main.java.com.lld.producerconsumer.consumer;

import main.java.com.lld.producerconsumer.buffer.Buffer;

public class Consumer<T> implements Runnable{
    private final Buffer<T> buffer;

    public Consumer(Buffer<T> buffer){
        this.buffer = buffer;
    }

    public void run(){
        while(true){
            try{
                T item = buffer.get();
                System.out.println(Thread.currentThread().getName() + " Consumed: " + item);
                Thread.sleep(500);
            }catch(InterruptedException ignored){

            }
        }
    }
}
