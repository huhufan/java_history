package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MyMeregeSort {

    static void merge(int [] a ,int left,int right){
        int n_mid = (right+left)/2;
        int i = left;
        int j = n_mid+1;

        int[] arr = Arrays.copyOfRange(a,left,right+1);

        for (int k =left;k<=right;k++) {
            if (i > n_mid) {
                a[k] = arr[j - left];
                j++;
            } else if (j > right) {
                a[k] = arr[i - left];
                i++;
            } else if (arr[i - left] < arr[j - left]) {
                a[k] = arr[i - left];
                i++;
            } else {
                a[k] = arr[j - left];
                j++;
            }
        }
    }
    static void sort(int [] a , int left , int right){
        if (left>=right)
            return;

        int m_mid = (left+right)/2;

        sort(a,left,m_mid);
        sort(a,m_mid+1,right);

        merge(a,left,right);
    }
    static void show(int[] a){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0;i<a.length;i++){
            s.append(a[i]);
            if (i!=a.length-1)
                s.append(",");
        }
        s.append("]");
        System.out.println(s.toString());;
    }
    static void swap(int[] a,int x,int y){
        int b = a[x];
        a[x] = a[y];
        a[y] = b;
    }

    static void insert_sort(int[] a){
        for (int i = 0;i<a.length;i++){
            int b = a[i];
            int index = i;
            for (int j=i+1;j<a.length;j++){
                if (a[j]<b){
                    b = a[j];
                    index = j;
                }
            }
            swap(a,i,index);
        }
    }

    public static void main(String[] args) {
        int a = 10000000;
        int[] array1 = new int[a];
        int[] array2 = new int[a];
        Integer[] array3 = new Integer[a];


        for (int i = 0; i<a;i++){
            int cc = (int) (Math.random()*a);
            array1[i] = cc;
            array2[i] = cc;
            array3[i] = cc;


        }
        long st1 = System.nanoTime();
        //insert_sort(array1);
        long end1 = System.nanoTime();
        long use1 = end1-st1;
        System.out.println("选择排序耗时:"+use1/(double)1000000000);
        long st2 = System.nanoTime();
        sort(array2,0,array2.length-1);
        long end2 = System.nanoTime();
        long use2 = end2-st2;
        System.out.println("归并排序耗时:"+use2/(double)1000000000);
        QKsort<Integer> qk = new QKsort<>();
        long st3 = System.nanoTime();
        qk.sort(array3);
        long end3 = System.nanoTime();
        long use3 = end3-st3;
        System.out.println("快速排序耗时:"+use3/(double)1000000000);





    }
}
