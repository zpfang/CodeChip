package cc.zpfang.sorts;

import com.alibaba.fastjson.JSON;
import lombok.extern.java.Log;

/**
 * Description:
 * Created by fangzp on 2018-01-03.
 */
@Log
public class Base{

   public static <T> boolean less(T var1, T var2){
       log.info(String.format("compare:%s, %s", var1, var2));
       if(var1 instanceof Comparable && var2 instanceof Comparable){
           return ((Comparable) var1).compareTo(var2) < 0;
       }
       throw new UnsupportedOperationException();
   }

   public static <T> void exchange(T[] list, int i, int k){
       log.info(String.format("exchange:%s, %s", i, k));
       T t = list[i];
       list[i] = list[k];
       list[k] = t;
   }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{4, 3, 2, 1};
        //Sort sort = new SelectionSort();
        //Sort sort = new InsertionSort();
        Sort sort = new ShellSort();
        sort.sort(list);
        log.info("sorted: " + JSON.toJSONString(list));
    }
}
