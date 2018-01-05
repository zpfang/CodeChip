package cc.zpfang.dataStructure.BagQueueStack;

/**
 * Description:
 * Created by zpfang on 2017/10/30.
 */
public interface IBag<T> extends Iterable<T>{

    void add(T item);

    boolean isEmpty();

    int size();

}
