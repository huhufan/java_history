package test_8_8;

public class Test {
    /**
     * 在try{}中，在执行 a = 2/0 语句时，发生异常，跳到catch{}中，执行a++，之后a变为1，
     * 执行return语句之前,catch{}中会把当前a值保存起来，然后跳到finally{}中，执行完finally之后，再回到catch{}中取出a,再执行return语句。
     * 因此，即使finally中对变量a进行了改变，也不会影响返回结果。
     */

    public static int f() {
        int a = 0;
        try {
            a = 2 / 0;
            return a;
        } catch (Exception e) {
            a++;
            return a + 1;
        } finally {
            System.out.println(a);// 输出 1
            a = 5;
        }
    }

    public static void main(String[] args) {
        System.out.println(f());    //输出 2
    }
}
