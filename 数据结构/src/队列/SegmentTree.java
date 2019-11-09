package 队列;

public class SegmentTree<E>  {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i=0;i<data.length;i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length*4];
        buildSegmentTree(0,0,data.length-1);

    }
    private void buildSegmentTree(int treeIndex,int l,int r){
        if (l==r){
           tree[treeIndex] = data[l] ;
           return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l+(r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }

    public int getSize(){
        return data.length;
    }
    public E get( int index){
        if (index < 0||index >= data.length)
            throw new IllegalArgumentException("Index is Illegal.");
        return data[index];
    }
    private int leftChild(int index){
        return 2*index+1;
    }
    private int rightChild(int index){
        return 2*index+2;
    }
    public void update(int index,E e){
        if (index < 0||index >= data.length)
            throw new IllegalArgumentException("Index is Illegal.");
        set(0,0,data.length-1,index,e);
    }
    private void set(int treeIndex,int l,int r,int index,E e){
        if (l==r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l+(r-l)/2;
        if (index>=mid+1)
            set(rightChild(treeIndex),mid+1,r,index,e);
        else{
            set(leftChild(treeIndex),l,mid,index,e);
        }
        tree[treeIndex] = merger.merge(tree[leftChild(treeIndex)],tree[rightChild(treeIndex)]);
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i =0;i<tree.length;i++){
            s.append(tree[i]);
            if (i!=tree.length-1)
                s.append(",");
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        Integer[] a = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(a, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree.toString());
    }
}
