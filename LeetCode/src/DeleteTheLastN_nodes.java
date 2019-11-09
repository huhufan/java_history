import java.util.List;

/**
 * @auther hu  .
 * @create 2019/10/23
 */

public class DeleteTheLastN_nodes {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);//head节点可能被删除，使用一个虚拟头结点指向head节点
        node.next = head;
        delete(node, n);
        return node.next;
    }

    private int delete(ListNode node, int n) {
        if (node.next == null)
            return 1;

        int a = delete(node.next, n);
        if (a == n)
            node.next = node.next.next;
        return a + 1;
    }
}
