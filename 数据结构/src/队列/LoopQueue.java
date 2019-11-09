package 队列;

public class LoopQueue<E> {
    private E[] arr ;
    private int front;
    private int end;

    public LoopQueue(int capacity){
        arr = (E[]) new Object[capacity+1];
        front = 0;
        end = 0;
    }
    public LoopQueue(){
        this(5);
    }
    public E out() {
        if (front == end){
            throw new IllegalArgumentException("数组为空");
        }
        if (end > front && end-front == arr.length/2)
            resize(arr.length/2+1);
        if (end < front && arr.length+end-front == arr.length/2)
            resize(arr.length/2+1);

        E b = arr[front];
        front=(front+1)%arr.length;
       return b ;
    };

    public void in(E e){
        if ((end+1)%arr.length==front)
            resize(arr.length*2-1);
        arr[end] = e;
        end=(end+1)%arr.length;
    }

    public void resize(int a){
        E[] arr2 = (E[]) new Object[a];
        for (int i = front;i!=end;i=(i+1)%arr.length){
            if (i<front)
                arr2[arr.length-front+i] = arr[i];
            else
                arr2[i-front] = arr[i];
        }
        end =end-front>0?end-front:arr.length+end-front;
        front = 0;
        arr = arr2;
        System.out.print("*******数组容量发生变化******");
        System.out.println(this);

    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("arr_length:"+arr.length+" ");
        stringBuilder.append("front:"+front+" ");
        stringBuilder.append("end:"+end+"   front[");
        for (int i=front;i!=end;i=(i+1)%arr.length){
            stringBuilder.append(arr[i]);
            if (i!=end-1)
                stringBuilder.append(",");
        }

        stringBuilder.append(" ]end");
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 1;i<=15;i++){
            loopQueue.in(i);
            System.out.println(loopQueue);

        }
        for (int i = 1;i<10;i++){
            loopQueue.out();
            System.out.println(loopQueue);
        }





    }



}
