package cc.zpfang.dataStructure.BagQueueStack.impl;

import cc.zpfang.dataStructure.BagQueueStack.IBag;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 * Created by zpfang on 2017/11/5.
 */
public class ArrayBag<T> implements IBag<T> {

    Object [] data;
    private static final int DEFAULT_INIT_FACTOR = 15;

    ArrayBag(int initFactor){
        if(initFactor <= 0){
            initFactor = DEFAULT_INIT_FACTOR;
        }
        data = new Object[initFactor];
    }

    int size = 0;

    @Override
    public void add(T item) {
        if(size > data.length){
            data = Arrays.copyOf(data, size * 3 / 2 + 3);
        }
        data[size] = item;
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
            int cusor = 0;
            @Override
            public boolean hasNext() {
                return cusor < data.length + 1;
            }

            @Override
            public T next() {
                Object o = data[cusor];
                cusor ++;
                return (T) o;
            }
        };
    }
}
