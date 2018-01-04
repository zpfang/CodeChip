package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class InsertionSort implements Sort {

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
