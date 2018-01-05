package cc.zpfang.dataStructure.BagQueueStack;

/**
 * Description:
 * Created by zpfang on 2017/10/30.
 */
public interface IQueue<T> extends Iterable<T>{

    void enqueue(T t);

    T dequeue();

    boolean isEmpty();

    int size();
}
