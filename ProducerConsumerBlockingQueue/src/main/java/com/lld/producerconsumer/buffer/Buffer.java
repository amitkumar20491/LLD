package main.java.com.lld.producerconsumer.buffer;

public interface Buffer<T> {
    void put(T item) throws InterruptedException;
    T get() throws InterruptedException;
}
