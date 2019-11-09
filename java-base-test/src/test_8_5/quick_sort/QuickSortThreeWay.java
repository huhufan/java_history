package test_8_5.quick_sort;

import java.util.Arrays;

public class QuickSortThreeWay {

    public static void sort(int[] data,int l,int r){
        if (l >= r)
            return;
        int lt = l;
        int gt = r+1;
        int i = l+1;

        int rand  = (int) (Math.random()*(r-l+1)+l);// 生成一个随机标定值
        swap(data,l,rand);
        int v = data[l];

        while (i < gt){
            if ( data[i] == v)
                i++;
            else if (data[i] < v){
                swap(data,i,lt+1);
                lt++;
                i++;
            }else {
                swap(data,i,gt-1);
                gt--;
            }
        }
        swap(data,l,lt);

        sort(data,l,lt-1);
        sort(data,gt,r);
    }

    //定义一个交换元素的方法
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,7,8,6,12,3,11};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
