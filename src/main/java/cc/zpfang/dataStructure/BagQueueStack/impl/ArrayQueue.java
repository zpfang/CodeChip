package cc.zpfang.dataStructure.BagQueueStack.impl;

import cc.zpfang.dataStructure.BagQueueStack.IQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description:
 * Created by zpfang on 2017/11/7.
 */
public class ArrayQueue<T> implements IQueue<T>{

    Object[] data;
    int putIndex;
    int takeIndex;
    int size;
    private static final int DEFAULT_INIT_FACTOR = 15;

    ArrayQueue(int initFactor){
        if(initFactor <= DEFAULT_INIT_FACTOR){
            initFactor = DEFAULT_INIT_FACTOR;
        }
        data = new Object[initFactor];
        putIndex = 0;
        takeIndex = 0;
        size = 0;
    }
    @Override
    public void enqueue(T t) {
        if(size == data.length){
            throw new StackOverflowError();
        }
        data[putIndex] = t;
        putIndex ++;
        if(putIndex == data.length){
            putIndex = 0;
        }
        size ++;
    }

    @Override
    public T dequeue() {
        if(takeIndex == putIndex){
            throw new NoSuchElementException();
        }
        T t = (T) data[takeIndex];
        takeIndex ++;
        if(takeIndex == data.length){
            takeIndex = 0;
        }
        size ++;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int start = takeIndex;
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public T next() {
                T t = (T)data[start];
                start ++;
                return t;
            }
        };
    }
}
