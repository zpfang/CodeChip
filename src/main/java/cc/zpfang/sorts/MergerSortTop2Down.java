package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class MergerSortTop2Down extends MergerSortBase {

    /**
     * 归并排序, 分治的思想
     * 自顶向下(依次归并左边的父节点)
     * 复杂度 O(nlogn) 空间复杂度O(n) 非稳定排序
     */
    @Override
    public void sort(Comparable[] list) {
        sort(list, 0, list.length - 1);

    }

    private void sort(Comparable[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        super.merge(array, left, mid, right);
    }
}