package month_5;

/**
 * 给出一个32位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 注意：
 * 假设我们的环境只能存储得下32位的有符号整数，则其数值范围为[-2的31次方 2 的31次方 - 1]请根据这个假设，如果反转后整数溢出那么就返回0。
 */
public class IntegerInversion {
    public int reverse(int x) {
        // 321
        int i = 0;
        while (x != 0){
            int a = x%10;
            x = x/10;
            if (i > Integer.MAX_VALUE/10 || (i == Integer.MAX_VALUE/10 && x > 7))
                return 0;
            if (i < Integer.MIN_VALUE/10 || (i == Integer.MIN_VALUE/10 && x < -8))
                return 0;
            i = i*10+a;
        }
        return i;
    }
}
