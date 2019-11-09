    package test_8_5;

    import java.util.Arrays;

    /**
     *  * 冒泡排序__从小到大
     */
    public class SelectSort {

        public static void  sort(int[] arr){
            int index_min;
            int value_min;
            for (int i = 0; i <= arr.length-2 ; i++) {
                index_min = i;
                value_min = arr[i];
                for (int j = i+1; j <= arr.length-1 ; j++) {
                    if (arr[j] < value_min){
                        index_min = j;
                        value_min = arr[j];
                    }
                }
                arr[index_min] = arr[i];
                arr[i] = value_min;
            }
       }


        public static void main(String[] args) {
            int[] a = {1,4,2,1,4,8,6,12,2,11};
            sort(a);
            System.out.println(Arrays.toString(a));
        }
    }
