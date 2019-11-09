package test_8_5.quick_sort;


import java.util.Arrays;

public class QuickSortTwoWay {

    public static void sort(int[] data , int l,int r){ //初始调用 sort(int[] data , 0, data.length-1)
           if (l>=r)
               return;
           int p = partition(data,l,r);
           sort(data,l,p-1);
           sort(data,p+1,r);
    }

    private static int partition(int[] data ,int l, int r) {
        int rand  = (int) (Math.random()*(r-l+1)+l);// 生成一个随机标定值
        swap(data,l,rand);

        int v = data[l];
        int i = l+1;
        int j = r;

        while (true){
            while (i <= r && data[i] < v)
                i++;
            while (j >= l+1 && data[j] > v)
                j--;
            /**
             *   如果是左边已经找到了一个 > v 的元素，退出来循环
             *   但是右边全部是 >v 的元素，于是j继续移动，直到移动到i的前一位才找到 < v 的元素，也退出循环
             *
             *   还有可能左边没有找到 > v 的元素 ，直到找到 j 或 j 的后一位才找到
             *   而此时如果是 j 的后一位，就说明当前j指向的是一个 < v 的元素，所以下一步 j 的循环判断 j 并不做任何移动
             *   而此时如果是 j 位，就说明当前j指向的是一个 > v 的元素，所以下一步 j 的循环判断 j 会向前移动一次
             *
             * 此时变成 j  i 的相邻顺序，但此时已经说明所有的元素都已遍历，且不需要任何的交换，直接break，
             * 而此时的 j 指向的是最 < v 的序列中的最后一个元素，交换 l,j 对应的值即可
             *
             * 这个过程可以左右互换做同样的思考。
             */
            if (j < i)
                break;
            swap(data,i,j);
            i++;
            j--; // 如果现在是 i j 的相邻顺序，经过i++,j--，变成 j i 的相邻顺序
        }
        swap(data,l,j);
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
