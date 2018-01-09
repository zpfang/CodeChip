package cc.zpfang.sorts;

import com.alibaba.fastjson.JSON;
import lombok.extern.java.Log;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
@Log
public class Base {

    public static <T> boolean less(T var1, T var2) {
        log.info(String.format("compare:%s, %s", var1, var2));
        if (var1 instanceof Comparable && var2 instanceof Comparable) {
            return ((Comparable) var1).compareTo(var2) < 0;
        }
        throw new UnsupportedOperationException();
    }

    public static <T> void exchange(T[] list, int i, int k) {
        log.info(String.format("exchange:%s, %s", i, k));
        T t = list[i];
        list[i] = list[k];
        list[k] = t;
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{4, 3, 2, 1, 7, 12, 90};
        //Sort sort = new SelectionSort();
        //Sort sort = new InsertionSort();
        //Sort sort = new ShellSort();
        //Sort sort = new MergerSortDown2Top();
        Sort sort = new MergerSortTop2Down();
        sort.sort(list);
        log.info("sorted: " + JSON.toJSONString(list));

       /* for (int i = 0; i < 20000; i++) {
            System.out.println("\"" + i + "这是一条验证短信。退订回TD\",");
        }*/
    }
}
