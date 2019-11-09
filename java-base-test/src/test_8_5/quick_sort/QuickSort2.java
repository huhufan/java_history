package test_8_5.quick_sort;


import java.util.Arrays;

public class QuickSort2 {

    public static void sort(int[] data , int l,int r){ //初始调用 sort(int[] data , 0, data.length-1)
           if (l>=r)
               return;
           int p = partition(data,l,r);
           sort(data,l,p-1);
           sort(data,p+1,r);

    }

    private static int partition(int[] data ,int l, int r) {
        //****************************************************************
        int rand  = (int) (Math.random()*(r-l+1)+l);// 生成一个随机标定值
        swap(data,l,rand);
        //****************************************************************
        int v = data[l];
        int j = l;
        for (int i = l+1; i <= r; i++) {
            if (data[i] < v){
                j++;
                swap(data,i,j); //进行步骤4的交换
            }
        }
        swap(data,l,j); //进行步骤5的交换
        return j;
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
