package test_7_31;

/**
 *              1
 *          /       \
 *         2          3
 *       /   \       /   \
 *      4     5     6     7
 *    /  \   / \   /  \  /  \
 *   8   9  10 a  b   c d    e
 *
 *       算法题：一个满二叉树，从上到下，轮流从左到右，从右到左打印，比如这道题的结果为 1 3 2 4 5 6 7 ......
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 定义一个二叉树节点
 */
class Node{
    Node left;
    Node right;
    int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public Node(){

    }

    static void show(Stack<Node> stack,Boolean flag){
        if (stack.empty())
            return;
        Stack<Node> stack_nextLayer = new Stack();
        Node node = null;
        if (flag){
            while (!stack.empty()){
                node = stack.pop();
                if (node == null)
                    continue;
                System.out.println(node.value+" ");
                stack_nextLayer.push(node.left);
                stack_nextLayer.push(node.right);
            }
            show(stack_nextLayer,!flag);
        }
        else {
            while (!stack.empty()){
                node = stack.pop();
                if (node == null)
                    continue;
                System.out.println(node.value);
                stack_nextLayer.push(node.right);
                stack_nextLayer.push(node.left);
            }
            show(stack_nextLayer,!flag);
        }

    }

    private static void recursion(List<Node> list) {
        List<Node> list_nextLayer = new ArrayList();
        for (Node node:list){
            list_nextLayer.add(node);
        }
    }
}

public class Test {
    //先构造一个测试的二叉树
    public static Node  buile(){
        Node n8 = new Node(null,null,8);
        Node n9 = new Node(null,null,9);
        Node n10 = new Node(null,null,10);
        Node n11 = new Node(null,null,11);
        Node n12 = new Node(null,null,12);
        Node n13 = new Node(null,null,13);
        Node n14 = new Node(null,null,14);
        Node n15 = new Node(null,null,15);
        Node n4 = new Node(n8,n9,4);
        Node n5 = new Node(n10,n11,5);
        Node n6 = new Node(n12,n13,6);
        Node n7 = new Node(n14,n15,7);
        Node n2 = new Node(n4,n5,2);
        Node n3 = new Node(n6,n7,3);
        Node n1 = new Node(n2,n3,1);
        return n1;
    }

    public static void main(String[] args) {
        Stack<Node> stack = new Stack();
        stack.push(Test.buile());
        Node.show(stack,true);
    }
}
