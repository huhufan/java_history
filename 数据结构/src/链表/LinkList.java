package 链表;

public class LinkList<E> {
    private class Node{
        private Node node;
        private E e;

        public Node(){
            this.node = null;
            this.e = null;
        }
        public Node(E e){
            this(null,e);
        }
        public Node(Node node,E e){
            this.node = node;
            this.e = e;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkList(){
        dummyHead = new Node();
        size = 0 ;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    public void add(int index , E e){
        if (index<0 || index>size)
            throw new IllegalArgumentException("index 非法");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
             pre = pre.node;
        }
        pre.node = new Node(pre.node,e);
        size++;
    }

    public E get(int index){
        if (index<0 || index>=size)
            throw new IllegalArgumentException("index 非法");
        Node pre = dummyHead;
        for (int i = 0;i<=index;i++)
            pre = pre.node;
        return pre.e;
    }


    public void set(int index, E e) {
        if (index<0 || index>size)
            throw new IllegalArgumentException("index 非法");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.node;
        }
        pre.node = new Node(pre.node.node,e);
    }

    public boolean contains(E e){
        Node cur = dummyHead.node;
        while(cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.node;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.node;
        while ((cur!=null)){
            stringBuilder.append(cur.e+"-->");
            cur = cur.node;
        }
        stringBuilder.append("NULL");
        return  stringBuilder.toString();
    }


    public void remove(int index){
        Node cur =dummyHead;
        for (int i =0;i<index;i++){
            cur = cur.node;
        };
        Node reNode = cur.node;
        cur.node = cur.node.node;
        reNode = null;
        size--;
    }
}
