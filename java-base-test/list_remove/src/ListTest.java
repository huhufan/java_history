import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ListTest {
    /**
     *  参考 https://blog.csdn.net/ghsau/article/details/9347357
     */

    @Test
    public void test1() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        for (int i = 0; i < intList.size(); i++) {
            Integer value = intList.get(i);
            // 符合条件，删除元素
            if (value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }

    /**
     * 输出：[1, 2, 5, 6]，漏掉了5这个元素，
     * 当i=2的时候，值为3，删除后，后面的元素往前补一位，
     * 这时i=3的时候，值为6，跳过了5，这样也不行
     */

    @Test
    public void test2() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        // for循环优化写法，只获取一次长度
        for (int i = 0, size = intList.size(); i < size; i++) {
            Integer value = intList.get(i);
            // 符合条件，删除元素
            if (value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }

    /**
     * 执行后，会抛出IndexOutOfBoundsException，
     * 因为集合中存在符合条件的元素，删除后，集合长度动态改变,
     * 由于长度只获取一次，发生越界，
     */

    @Test
    public void test3() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        //使用增强for循环
        for (Integer value : intList) {
            // 符合条件，删除元素
            if (value == 3 || value == 5) {
                intList.remove(value);
            }
        }
        System.out.println(intList);
    }

    /**
     * 执行后，会抛出ConcurrentModificationException，字面意思是并发修改异常
     * 可以大概看出是执行到AbstractList中内部类Itr的 checkForComodification 方法抛出的异常
     * 这里可以大概解释一下。集合遍历是使用Iterator, Iterator是工作在一个独立的线程中，并且拥有一个互斥锁。
     * Iterator 被创建之后会建立一个指向原来对象的单链索引表
     * 当原来的对象数量发生变化时，这个索引表的内容不会同步改变，所以当索引指针往后移动的时候就找不到要迭代的对象，
     * 所以按照 fail-fast原则 Iterator 会马上抛出java.util.ConcurrentModificationException 异常。
     * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。
     */

    @Test
    public void test4() {

        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        //使用迭代器
        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            if (value == 3 || value == 5) {
                it.remove();
            }
        }
        System.out.println(intList);
    }

    /**
     * 输出正确结果：[1, 2, 6]。
     */

    @Test
    public void test5() {
        List<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 1, 2, 3, 5, 6);
        //还有种取巧的方式是从最后一个元素开始遍历，符合条件的删除
        for (int i = intList.size() - 1; i >= 0; i--) {
            Integer value = intList.get(i);
            if (value == 3 || value == 5) {
                intList.remove(i);
            }
        }
        System.out.println(intList);
    }
    /**
     * 输出正确结果：[1, 2, 6]。
     */
}