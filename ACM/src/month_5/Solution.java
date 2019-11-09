package month_5;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode node = this;
        while (node!=null){
            s.append(node.val+"-->");
            node=node.next;
        }
        return s.toString();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        return f(l1,l2,new ListNode(0),0); 
    }
    public ListNode f(ListNode l1, ListNode l2,ListNode node,int j){
        if (l1==null&&l2==null&&j==0)
            return null;
        int a=0,b=0;
        a = (l1==null)?0:l1.val;
        b = (l2==null)?0:l2.val;
        int sum = a+b+j;
        int wei = sum%10;
        j = sum>=10?1:0;
        node.val=wei;
        node.next=f(l1==null?null:l1.next,l2==null?null:l2.next,new ListNode(0),j);
        return node;
    }

    public static void main(String[] args) {

    }
}