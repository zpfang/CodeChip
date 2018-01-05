package cc.zpfang.dataStructure.BagQueueStack;

/**
 * Description:
 * Created by zpfang on 2017/10/30.
 */
public interface IStack<T> extends Iterable<T> {

    void push(T t);

    T pop();

    boolean isEmpty();

    int size();
}
