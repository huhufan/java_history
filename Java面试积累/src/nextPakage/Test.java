package nextPakage;

import 基础.Cat;

import java.util.function.BinaryOperator;


public class Test   {

    /**
     * 逻辑左移=算术左移：高位溢出，低位补0
     * 逻辑右移：低位溢出，高位补0
     * 算术右移：低位溢出，高位用符号位的值补
     *
     * 比如一个有符号位的8位二进制数10101010，[]是添加的数字
     *
     * 逻辑左移一位：0101010[0]
     * 逻辑左移两位：101010[00]
     *
     * 算术左移一位：0101010[0]
     * 算术左移两位：101010[00]
     *
     * 逻辑右移一位：[0]1010101
     * 逻辑右移两位：[00]101010
     *
     * 算术右移一位：[1]1010101
     * 算术右移两位：[11]101010
     * ---------------------
     * 作者：_仰望星空_脚踏实地
     * 来源：CSDN
     * 原文：https://blog.csdn.net/zzti_erlie/article/details/80204053
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     */
    static final int hash(int key) {
        int h;
        h = key^ (key >>> 16);
        return h;
    }
    public static void main(String[] args) {
        int b = 106;
        System.out.println(Integer.MAX_VALUE);
        System.out.println("移位前的结果:"+b+"                              "+Integer.toBinaryString(b));
        System.out.println("逻辑右移一位 >>>1 的结果："+(b>>>1)+"            "+Integer.toBinaryString(b>>>1));
        System.out.println("算数右移一位 >>1  的结果："+(b>>1)+"             "+Integer.toBinaryString(b>>1));

        System.out.println("算数左移一位或逻辑左移一位 <<1 的结果："+(b<<1)+"           "+Integer.toBinaryString(b<<1));
        System.out.println("------------------------------------------------------------");
        int c = -2147323642;
        System.out.println("移位前的结果:"+c+"                              "+Integer.toBinaryString(c));
        System.out.println("逻辑右移一位 >>>1 的结果："+(c>>>1)+"            "+Integer.toBinaryString(c>>>1));
        System.out.println("算数右移一位 >>1  的结果："+(c>>1)+"             "+Integer.toBinaryString(c>>1));
        System.out.println("算数左移一位或逻辑左移一位 <<1 的结果："+(c<<1)+"      "+Integer.toBinaryString(c<<1));


        int d = 164565575;
        int e = d>>>16;
        System.out.println(d^e);
        System.out.println(Test.hash(d));


    }
}
