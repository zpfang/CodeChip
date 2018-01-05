package cc.zpfang.sorts;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
public class SelectionSort implements Sort{

    /**
     * 选择排序(冒泡排序)
     * 通过两层循环,依次选出最小的值
     */
    @Override
    public void sort(Comparable[] list) {
        if(list == null || list.length == 0){
            return;
        }
        for(int i = 0; i < list.length; i ++ ){
            for(int k = i + 1; k < list.length; k ++){
                if(Base.less(list[k], list[i])){
                        Base.exchange(list, i, k);
                }
            }
        }
    }
}
