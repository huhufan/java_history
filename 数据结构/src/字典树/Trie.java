package 字典树;

import java.util.TreeMap;

public class Trie {
     private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<Character,Node>();
        }
        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    public void  add(String s){
        Node cur = root;
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
            size++;

        }
    }
    public boolean contains(String s){
        Node cur = root;
        for (int i=0;i <s.length();i++){
            char c = s.charAt(i);
            if (!cur.next.containsKey(c))
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     *
     * @param s ' . '可以匹配任何字符
     * @return
     */
    public boolean search(String s){
        return match(root,s,0);

    }
    private boolean match(Node node,String s,int index){
        if (index == s.length())
            return node.isWord;

        char c = s.charAt(index);
        if (c!='.'){
            if (node.next.get(c)==null)
                return false;
             return match(node.next.get(c),s,index++);
        }
        else{
            for (char nextChar:node.next.keySet()){
                if (match(node.next.get(nextChar),s,index++))
                    return true;
            }
        }
        return false;
    }
}
