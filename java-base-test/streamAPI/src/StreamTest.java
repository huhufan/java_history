import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @auther hu  .
 * @create 2019/8/19
 */


public class StreamTest {
    //创建stream
    @Test
    public void test() {
        //1.通过集合
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();

        //2.通过数组
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(arr);

        //3.通过Stream.of
        Stream<Integer> objectStream = Stream.of(1, 2, 3, 4, 5);

        //4.创建无限流
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //迭代前十个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //public static<T> Stream<T> generate(Supplier<T> s) {
        //生成十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //Stream的中间操作:筛选与切片
    @Test
    public void test2() {
        /**
         * filter(Predicate P) 接受lambda,从流中排除某些元素
         * distinct() 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
         * limit（long maxSize),截断流，使其元素不超过指定数量
         * skip(long n)跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 2);
        list.stream().filter(t -> t < 4).forEach(System.out::println); // 1 2 3 3 2

        list.stream().distinct().forEach(System.out::println);    // 1 2 3 4 5

        list.stream().limit(3).forEach(System.out::println);     //  1 2 3

        list.stream().skip(2).forEach(System.out::println);     //   3 4 5 3 2
    }

    //Stream的中间操作:映射
    @Test
    public void test3() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        // map 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        list.stream().map(t -> t.toUpperCase()).forEach(System.out::println); // AA BB CC

        // flatMap(接受一个函数作为参数，将流中的每个值都换成另外一个流，然后把所有流连接成一个流
        list.stream().flatMap(StreamTest::forStringToStream).forEach(System.out::println); // a  a  b  b  c  c
    }

    public static Stream<Character> forStringToStream(String s) {
        ArrayList<Character> list = new ArrayList();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //Stream的中间操作:排序
    @Test
    public void test4() {

        List<Integer> list = Arrays.asList(22, 5, 3, -1, 33, 4);
        // Stream<T> sorted();自然排序
        list.stream().sorted().forEach(System.out::println); // -1 3 4 5 22 33 默认从小到大
        // Stream<T> sorted(Comparator<? super T> comparator);定制排序
        list.stream().sorted((a, b) -> {
            return -Integer.compare(a, b); //33 22 5 4 3 -1  定制从大到小
        }).forEach(System.out::println);
    }

    //Stream的终止操作-匹配与查找
    @Test
    public void test5() {
        /**
         * allMatch(Predicate p)-检查是否匹配所有元素
         * anyMarch
         * noneMatch
         *
         * findFirst-返回第一个元素
         * findAny
         *
         * count-返回流中元素的总个数
         * max(Comparator c)-返回最大值
         * min
         *
         * forEach(Consumer c)-内部迭代
         */
    }

    //Stream的终止操作-归约
    @Test
    public void test6() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //Optional<T> reduce(BinaryOperator<T> accumulator);
        //T reduce(T identity, BinaryOperator<T> accumulator);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);// 0+1+2+3+4+5
    }

    //Stream的终止操作-收集
    @Test
    public void test7() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //  collect(Collector collector);将流转换为其他形式

        Set<Integer> set = list.stream().filter(t -> t > 2).collect(Collectors.toSet());
        System.out.println(set);// [3, 4, 5]
    }


}
