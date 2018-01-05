package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class MergerSort implements Sort {

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
        merge(array, left, mid, right);
    }

    private void merge(Comparable[] array, int left, int mid, int right) {
        int h = right - left + 1;
        int l = left;
        int r = mid + 1;
        Comparable[] copyArray = new Comparable[array.length];
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