package 链表;

public class Test {
    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 0; i <= 8; i++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.add(5,5);
        System.out.println(linkList);
        linkList.set(2,2);
        System.out.println(linkList);
        System.out.println(linkList.contains(5));
        linkList.remove(2);
        System.out.println(linkList);
        linkList.remove(5);
        System.out.println(linkList);

    }
}
