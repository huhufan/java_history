package SwingBase;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
     int canvasWidth;
     int canvasHeight;
     int N;
     int R =50;
     Circle[] circles;
     AlgoFrame frame;
     boolean isAnimated ;

    public Controller(int canvasWidth, int canvasHeight, int n,boolean isAnimated) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.isAnimated = isAnimated;
        N = n;
        circles = new Circle[N];
        for (int i = 0; i < N; i++) {
            int x = (int) ((Math.random() * canvasWidth - 2 * R) + R);
            int y = (int) ((Math.random() * canvasHeight - 2 * R) + R);
            int vx = (int) (Math.random() * 11 - 5);
            int vy = (int) (Math.random() * 11 - 5);
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        frame = new AlgoFrame("小球翻滚吧",canvasWidth,canvasHeight);
        frame.addKeyListener(new KeyListener());
        frame.addMouseListener(new MouseListener());

    }

    public void run(){
        EventQueue.invokeLater(() -> {
            new Thread(() -> {
                while (true) {
                    frame.render(circles);
                    AlgoVisHelper.pause(20);
                    if (isAnimated){
                        for (Circle c : circles) {
                            c.move(0, canvasWidth, 0, canvasHeight);
                        }
                    }

                }
            }).start();
        });
    }
    private class KeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event){
            if (event.getKeyChar()==' '){
                isAnimated = !isAnimated;
            }
        }
    }
    private class MouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            event.translatePoint(0,canvasHeight-frame.getBounds().height);
            for (Circle c:circles){
                 if (c.isPress(event.getPoint()))
                     c.isFilled = !c.isFilled;
            }
        }
    }
}
