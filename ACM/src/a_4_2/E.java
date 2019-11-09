package a_4_2;

public class E {
    public static void main(String[] args) {
        String[] a = {"lisdasd","lisssss","liseeoo"};

        String re = "";
        e:for (int i=0;i<a.length;i++){
            char c = a[1].charAt(i);
            for (int j =1;j<a.length;j++){
                if (a[j].charAt(i)!=c){
                    break e;
                }
            }
            re = re+c;
        }
        System.out.println(re);
    }
}
