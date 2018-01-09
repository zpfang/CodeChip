package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public abstract class MergerSortBase implements Sort {

    public void merge(Comparable[] array, int left, int mid, int right) {
        int h = right - left + 1;
        int l = left;
        int r = mid + 1;
        Comparable[] copyArray = new Comparable[array.length];
        //每次归并都拷贝会有性能问题, 可提出为变量, 只拷贝一次
        System.arraycopy(array, left, copyArray, left, h);
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                array[i] = copyArray[r];
                r++;
            } else if (r > right) {
                array[i] = copyArray[l];
                l++;
            } else if (Base.less(copyArray[r], copyArray[l])) {
                array[i] = copyArray[r];
                r++;
            } else {
                array[i] = copyArray[l];
                l++;
            }
        }
    }
}