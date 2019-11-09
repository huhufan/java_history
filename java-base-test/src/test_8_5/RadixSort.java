package test_8_5;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int[] data){

        int max = data[0];
        for (int i = 1; i < data.length; i++) {                   //找出位数最长的数
            if (data[i] > max)
                max = data[i];
        }
        int max_length = (max+"").length();                        //得到最大数的长度

        int[][] bucket = new int[10][data.length];                // 定义10个容量为data.length的桶
        int[] bucket_size = new int[10];                           // 定义一个记录每个桶的存放元素数量的数组

        for (int k = 0; k < max_length ; k++) {                    //根据最大数的位数长度，决定要循环的次数
            for (int d = 0; d < data.length; d++) {               //循环data数组中的数据
                int num = data[d]/(int)Math.pow(10,k)%10;         // 得到当前位数的值
                bucket[num][bucket_size[num]] = data[d];           // 放入对应的桶中
                bucket_size[num]++;                                // 放入元素对应的桶的存放元素数量加1
            }
            int index = 0;
            for (int b = 0; b < 10 ; b++) {                       //把从0号桶至九号桶取出所有元素，对应更新data中的元素排布
                for (int bs = 0; bs < bucket_size[b] ; bs++) {
                    data[index] = bucket[b][bs];
                    index++;
                }
                bucket_size[b] = 0;                               // 取出每个桶的元素，对应的存放元素数量应置为0
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {53,3,542,748,14,234599,214};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
