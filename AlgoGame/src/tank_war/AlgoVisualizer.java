package tank_war;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.Timer;
import java.util.TimerTask;

import static sun.misc.PostVMInitHook.run;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private TankWarData data;        // 数据
    private static int blokeSide = 59;
    private boolean canLaunch = true;
    private static int DELAY = 5;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(String filename){

        // 初始化数据
        // TODO: 初始化数据

        data = new TankWarData(filename);
        data.print();
        int sceneWidth = data.M()*blokeSide;
        int sceneHeight = data.N()*blokeSide;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
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
            AlgoVisHelper.pause(500);
            data.buffetMove();
            strike(-1);
        }
    }
    private void strike(int ope){
        if (ope > -1) {
            data.myTankMove(ope);
        }
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }
    public void key_32(){
        data.addBullet();
        data.buffetMove();
        strike(-1);
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode()== 32 ){
                key_32();
            }
            else if (event.getKeyCode()== 38){
                strike(0);
            }
            else if (event.getKeyCode()== 39)
                strike(1);
            else if (event.getKeyCode()== 40)
                strike(2);
            else if (event.getKeyCode()== 37)
                strike(3);
        }
    }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {
        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer("resource/tank_war/tank1.txt");
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                visualizer.canLaunch = true;
//            }
//        },0,1500);
    }
}
