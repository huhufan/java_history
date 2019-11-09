package a_4_2;

/**
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 *
 * 输入例子1:
 * 1999 2299      11111001111
 * 输出例子1:    100011111011
 * 7
 */
public class Binary_diff {

    public  int f(int a,int b){
        int num = 0;
        while(true){
            int ay = a%2;
            a=a/2;
            int by = b%2;
            b=b/2;
            if (ay!=by)
                num++;
            if (a==0 && a==b)
                break;

        }
        return num;
    }

    public static void main(String[] args) {
        Binary_diff b = new Binary_diff();
        System.out.println(b.f(1999,2299));
    }
}
