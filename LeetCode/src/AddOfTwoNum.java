/**
 * @auther hu  .
 * @create 2019/10/1
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddOfTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int var1 = 0;
        int var2 = 0;
        int result = 0;
        ListNode node = new ListNode((l1.val + l2.val)%10);
        int carry =(l1.val + l2.val)/10 ;
        ListNode empty = new ListNode(0);
        ListNode return_node = node;
        while (l1.next != null || l2.next != null) {
            var1 = l1.next == null ? 0 : l1.next.val;
            var2 = l2.next == null ? 0 : l2.next.val;
            result = var1 + var2 + carry;
            node.next = new ListNode(result % 10);
            carry = result / 10;
            node = node.next;
            l1 = l1.next == null ? empty : l1.next;
            l2 = l2.next == null ? empty: l2.next;
        }
        if (carry != 0)
            node.next = new ListNode(carry);
        return return_node;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n4.next = n5;
        n5.next = n6;

        ListNode node = new AddOfTwoNum().addTwoNumbers(n1, n4);
        System.out.print(node.val);
        while (node.next != null) {
            node = node.next;
            System.out.print( " "+node.val );
        }
    }
}
