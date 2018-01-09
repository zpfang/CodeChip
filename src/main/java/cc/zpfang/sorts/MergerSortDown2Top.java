package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class MergerSortDown2Top extends MergerSortBase{


    /**
     * 归并排序, 分治的思想
     * 自底向上(先归并所有的小分组, 再依次归并稍微大一点的)
     * 层层选拔, 这种便于分布式
     * 复杂度 O(nlogn) 空间复杂度O(n) 非稳定排序
     */
    @Override
    public void sort(Comparable[] list) {
        int N = list.length;
        for (int sz = 1; sz < N; sz = sz + sz) {
            //当数组大小为sz的倍数时, 最后一个数组的大小才等于sz
            //否则最后一个数组的大小都是小于sz的, 故最后一个数组大小介于sz和N-sz中的最小值
            //而最后一次的k值大小介于N-sz到N-sz-sz之间, 故这里k < N-sz
            for (int k = 0; k < N - sz; k += sz + sz) {
                super.merge(list, k, k + sz - 1, Math.min(k + sz + sz - 1, N - 1));
            }
        }
    }
}