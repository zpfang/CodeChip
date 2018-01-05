package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class InsertionSort implements Sort {

    /**
     * 插入排序
     * 局部有序, 先保证最前面的有序, 然后依次有序, 类似后面的数据是新插入的
     */
    @Override
    public void sort(Comparable[] list) {
        if (list == null || list.length == 0) {
            return;
        }
        for (int i = 1; i < list.length; i++) {
            for (int k = i; k > 0 && Base.less(list[k], list[k-1]); k--) {
                Base.exchange(list, k, k-1);
            }
        }
    }
}
