package ttest.tst;

import java.util.ArrayList;

/**
 * @Author ssqswyf
 * @Date 2021/7/31
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("list = " + list);
        list.add("asfdas");
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.size() = " + list.size());
        list.clear();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("sadfsa");
        System.out.println("strings = " + strings);


    }
}
