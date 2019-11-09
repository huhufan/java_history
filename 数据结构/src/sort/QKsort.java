package sort;

import org.omg.CORBA.PUBLIC_MEMBER;

public class QKsort<E extends Comparable<E>>{

    public void sort(E[] a){
        sort(a,0,a.length-1);
    }
    public void sort(E[] a,int le,int re) {
        if (le>=re)
            return;
        int j = partition(a, le, re);
        sort(a,le,j-1);
        sort(a,j+1,re);
    }
    public int partition(E[] a,int le,int re){
        int j = le;
        E e = a[le];
        for(int i = le+1;i<=re;i++){
            if (a[i].compareTo(e)<=0){
                j++;
                swap(a,j,i);
            }
        }
        swap(a,le,j);
        return j;
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
        QKsort<Integer> qk = new QKsort<>();
        qk.sort(array1);
        for (int i = 0; i < a; i++) {
            System.out.print(array1[i]+" , ");
        }

        }

}

