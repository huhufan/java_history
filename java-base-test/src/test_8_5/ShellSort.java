package test_8_5;

import java.util.Arrays;

/**
 * 希尔排序 -- 从小到大
 */
public class ShellSort {
    //对有序序列在插入时采用【交换】法
    public static void sort(int[] data) {
        for (int i = data.length / 2; i > 0; i = i / 2) {  //步长
            for (int j = i; j <= data.length - 1; j++) {
                for (int k = j; k - i >= 0; k = k - i) {
                    if (data[k] < data[k - i]) {
                        int tmp = data[k];
                        data[k] = data[k - i];
                        data[k - i] = tmp;
                    }
                }
            }
        }
    }

    //对有序序列在插入时采用【移位】法,效果更佳！
    public static void sort2(int[] data) {
        for (int i = data.length / 2; i > 0; i = i / 2) {  //步长
            for (int j = i; j <= data.length - 1; j++) {
                int insert_value = data[j];
                int insert_index = j;
                while (insert_index-i >= 0 && insert_value < data[insert_index-i]) {
                    data[insert_index] = data[insert_index-i];
                    insert_index = insert_index - i;
                }
                data[insert_index] = insert_value;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 14, 7, 15, 4, 8, 6, 12, 3, 99, 2, 11};
        sort2(a);
        System.out.println(Arrays.toString(a));
    }
}
