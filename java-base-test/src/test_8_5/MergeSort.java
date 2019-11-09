package test_8_5;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] data, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        sort(data, l, mid);
        sort(data, mid + 1, r);
        merge(data, l, mid, r);
    }

    private static void merge(int[] data, int l, int mid, int r) {
        int[] tmp = Arrays.copyOfRange(data, l, r + 1); //将data数组中 l 到 r 的元素拷贝到一个临时数组中，下面操作的时候直接改变data数组中的值
        int l_index = l;                                   //左边索引从 l 开始
        int r_index = mid + 1;                             //右边索引从mid+1开始
        for (int i = l; i <= r; i++) {
            if (l_index > mid) {                           //说明左边部分以全部处理完毕
                data[i] = tmp[r_index - l];
                r_index++;
            }
            else if (r_index > r) {                       //说明右边部分以全部处理完毕
                data[i] = tmp[l_index - l];
                l_index++;
            }
            else if (tmp[l_index-l] < tmp[r_index-l]) {    //左边所指元素 < 右边所指元素
                data[i] = tmp[l_index-l];
                l_index++;
            }
            else {                                       //左边所指元素 >= 右边所指元素
                data[i] = tmp[r_index-l];
                r_index++;
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,4,7,0,3,8,6,12,2,11};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
