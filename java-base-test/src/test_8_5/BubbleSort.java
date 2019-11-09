package test_8_5;

import java.util.Arrays;

/**
 * 冒泡排序__从小到大
 * 【3.5.2.1.8.6】----->【3.2.1.5.6,8】->【2.1.3.5.6,8】->【1.2.3.5.6,8】->【1.2.3.5.6,8】->【1.2.3.5.6,8】
 *                          5次比较            4次比较          3次比较            2次比较           1次比较
 */
public class BubbleSort {

    /**
     * 普通版本
     */

    public static int[] sort(int[] arr){
        int tem;
        for (int i = 0; i <= arr.length-2; i++) {
            for (int j = 0; j <= arr.length-2-i; j++) {
                if (arr[j]>arr[j+1]){
                    tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }
        return arr;
    }

    /**
     * 优化版本
     * 如果在一趟比较中，发现没有进行过交换，则说明序列有效，设置一个flag判断是否进行过交换从而减少不必要的比较
     */
    public static int[] sort2(int[] arr){
        int tem;
        boolean flag = false;
        for (int i = 0; i <= arr.length-2; i++) {
            for (int j = 0; j <= arr.length-2-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag = true;
                    tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
            if (!flag)
                break;
            else
                flag = false;
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] a = {1,4,2,90,11,6,4,21,2,40};
        sort(a);
        System.out.println(Arrays.toString(a));
        int[] b = {1,4,2,90,11,6,4,21,2,40};
        sort2(b);
        System.out.println(Arrays.toString(b));
    }
}
