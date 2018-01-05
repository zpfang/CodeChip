package cc.zpfang.structure;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Consumer;

/**
 * Description:
 * Created by fangzp on 2017-12-14.
 */
public class DataType {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("hello");
        final String[] hello = {""};
        list.forEach(((Consumer<String>) System.out::println).andThen(s -> hello[0] = s + "1121"));
        System.out.println(list);
        System.out.println(hello[0]);

        list.spliterator();
    }
}
