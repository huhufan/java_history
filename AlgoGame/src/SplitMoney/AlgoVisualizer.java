package SplitMoney;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {
    static int sum = 0;

    // TODO: 创建自己的数据
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        // TODO: 初始化数据
        money = new int[100];
        for (int i =0;i<money.length;i++){
            money[i] = 100;
        }

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        // TODO: 编写自己的动画逻辑
        while (true){
            frame.render(money);
            frame.render2(sum);
            AlgoVisHelper.pause(5);
            Arrays.sort(money);
                for (int i=0;i<money.length;i++){
                        int j = 0;
                        while (true){
                            j = (int) (Math.random()*money.length);
                            if (j!=i)
                                break;
                        }
                        money[i] -=1;
                        money[j] +=1;
            }
            sum++;

        }
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
