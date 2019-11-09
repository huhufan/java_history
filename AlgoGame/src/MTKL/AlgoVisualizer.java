package MTKL;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private Circle circle;
    private ArrayList<Point> points;        // 数据
    private AlgoFrame frame;
    private int N;// 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int n){

        // 初始化数据
        // TODO: 初始化数据
        this.N = n;
        circle = new Circle(sceneWidth/2,sceneHeight/2,sceneHeight/2);
        points = new ArrayList<>();

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        int cir_in = 0;
        for (int i =0;i<N;i++){
            if (i%100==0){
                frame.render(circle,points);
                AlgoVisHelper.pause(40);
                System.out.println(4*(double)cir_in/(i+1));
            }
            int x = (int) (Math.random()*frame.getCanvasWidth());
            int y = (int) (Math.random()*frame.getCanvasHeight());
            Point p = new Point(x,y);
            if (circle.contain(p))
                cir_in++;
            points.add(p);
        }
        // TODO: 编写自己的动画逻辑
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,10000);
    }
}
