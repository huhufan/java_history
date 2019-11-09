package sort;

public class QKsort_3path<E extends Comparable<E>>{

    public void sort(E[] a){
        sort(a,0,a.length-1);
    }
    public void sort(E[] a,int le,int re) {
        if (le>=re)
            return;
        //三路快排
        int lt = le;
        int gt = re+1;
        int i = le+1;
        //选取第一个元素作为比较对象
        E e = a[le];
        while (i<gt){
            if (a[i].compareTo(e)<0){
                lt++;
                swap(a,lt,i);
                i++;
            }
            else if (a[i].compareTo(e)>0){
                gt--;
                swap(a,gt,i);
            }
            else
                i++;
        }
        swap(a,le,lt);

        sort(a,le,lt-1);
        sort(a,gt,re);
    }

    private void swap(E[] a,int i,int j){
        if (i<0 || i>a.length-1 || j<0 || j>a.length-1 )
            throw new IllegalArgumentException("参数不合法");
        E ei = a[i];
        a[i] = a[j];
        a[j] = ei;
    }

    public static void main(String[] args) {
        int a = 20;
        Integer[] array1 = new Integer[a];
        for (int i = 0; i < a; i++) {
            int cc = (int) (Math.random() * 2*a);
            array1[i] = cc;
        }
        QKsort_3path<Integer> qk = new QKsort_3path<>();
        qk.sort(array1);
        for (int i = 0; i < a; i++) {
            System.out.print(array1[i]+" , ");
        }

        }

}

