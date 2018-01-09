package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class ShellSort implements Sort {

    /**
     * 希尔排序
     * 插入排序的改进版
     * 先分成几组, 对每个组内的相同序号的元素进行选择排序
     * 调整步长, 直到步长为1, 每次调整步长执行上一步
     * 复杂度 O(n^1.3) 空间复杂度O(1) 非稳定排序
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
