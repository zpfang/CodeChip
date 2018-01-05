package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class ShellSort implements Sort {

    /**
     * 希尔排序
     * 插入排序的改进版
     *
     */
    @Override
    public void sort(Comparable[] list) {
        if (list == null || list.length == 0) {
            return;
        }
        int step = 1;
        while (step < list.length / 2) step = 2 * step + 1;
        while (step >= 1){
            for (int i = step; i < list.length; i++) {
                for (int k = i; k >= step && Base.less(list[k], list[k-step]); k -= step) {
                    Base.exchange(list, k, k-step);
                }
            }
            step = step / 2;
        }

    }
}
