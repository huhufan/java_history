/**
 * @auther hu  .
 * @create 2019/10/4
 *
 *
 *
 *                  ---|---                           |                          |
 *                -----|-----                         |                          |
 *              -------|-------                       |                          |
 *          ————————————         ————————————     ————————————
 *                   A                              B                            C
 *
 */
public class HanoiTower {

    public static void hanoiTower(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果有num>=2的情况，我们总是可以看成是两个盘：最下面的一个盘、上面的所有盘
            //1. 先把上面的所有盘A->B,移动过程中会用到c塔
            hanoiTower(num - 1, a, c, b);
            //2. 把最下面的一个盘A->C
            System.out.println("第" + num + "个盘从" + a + "->"+c);
            //3. 把B塔的所有盘B->C,移动过程中会用到a塔
            hanoiTower(num - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }
}
