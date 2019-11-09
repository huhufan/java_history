package test_8_5;

import java.util.Arrays;

/**
 * 插入排序--从小到大
 */
public class InsertSort {

    public static void sort(int[] arr){
        for (int i = 1; i <= arr.length-1 ; i++) {
            int cur_value = arr[i]; //记录待插入的数
            int cur_index = i;  // 以当前待插入数的索引为起点，将前面的比 待插入数 大的的数后移
            while (cur_index-1 >= 0  && cur_value < arr[cur_index-1] ){
                arr[cur_index] = arr[cur_index-1];
                cur_index--;
            }
            arr[cur_index] = cur_value;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,4,2,7,8,6,12,2,11};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
