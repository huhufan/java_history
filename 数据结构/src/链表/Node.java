package 链表;

public class Node<E> {
    private Node next;
    private E value;

    public Node(Node next,E value ){
        this.next = next;
        this.value = value;
    }

    public Node() {

    }


    public void addFirst(Node head,E value){
            head.next = new Node(head.next,value);
    }

    public void addEnd(Node head,E value){
        while (head.next != null){
            head = head.next;
        }
        head.next = new Node(null,value);
    }
    public void remove(E value) {
        Node node = this;
        while (node.next != null) {
            if (node.next.value == value)
                node.next = node.next.next;
            else
                node = node.next;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("head->");
        Node node = this.next;
        while(node!=null){
            s.append(node.value+"->");
            node = node.next;
        }
        s.append("null");
        return s.toString();
    }
    public void delete(Node node ,E value){
        Node n = node.next;
        if (n == null)
            return;
        if (n.value == value)
            n.next = n.next.next;
        delete(n.next,value);

    }

    public static void main(String[] args) {
        Node<Integer> dummyNode = new Node<>();
        dummyNode.addFirst(dummyNode,1);
        dummyNode.addFirst(dummyNode,2);
        dummyNode.addFirst(dummyNode,3);
        dummyNode.addEnd(dummyNode,4);
        dummyNode.addFirst(dummyNode,1);
        dummyNode.addFirst(dummyNode,2);
        dummyNode.addFirst(dummyNode,2);
        dummyNode.addFirst(dummyNode,3);
        dummyNode.addEnd(dummyNode,4);
        dummyNode.addFirst(dummyNode,1);
        System.out.println(dummyNode);
        //dummyNode.remove(1);
        System.out.println(dummyNode);
        Node E = dummyNode;
        dummyNode.delete(E,2);
        System.out.println(dummyNode);



    }
}
