package 队列;

public class Array<E> {
    E[] data;
    int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public void addLast(E e){
        if (size == data.length)
            this.resize();
        data[size] = e;
        size++;
    }
    public void removeLast(){
        data[size-1] = null;
        size--;
    }
    public void resize(){
        E[] data2 = (E[]) new Object[data.length*2];
        for (int i = 0;i<data.length;i++){
            data2[i] = data[i];
        }
        data = data2;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public void swap(int i,int j){
        if (i<0 || i>=size || j<0 || j>=size){
            throw new IllegalArgumentException("参数错误");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    public E get(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("参数错误");
        }
        return data[index];
    }
}
