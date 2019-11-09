package SplitMoney;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);

        setResizable(false);
        pack();    // 在setResizable(false)后进行pack()，防止在Windows下系统修改frame的尺寸
                   // 具体参见：http://coding.imooc.com/learn/questiondetail/26420.html

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // TODO: 设置自己的数据
    private int[] money;
    public void render(int[] money){
        this.money = money;
        repaint();
    }
    private int sum;
    public void render2(int sum){
        this.sum = sum;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            // TODO： 绘制自己的数据data
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
            AlgoVisHelper.setColor(g2d, AlgoVisHelper.Cyan);
            String a = "已交易"+sum+"轮";
            AlgoVisHelper.drawText(g2d,a,canvasWidth/2,50);
            for (int i = 0 ; i<money.length;i++){
                int w = canvasWidth/money.length;
                int m = money[i];
                if (m>0){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Blue);
                    AlgoVisHelper.fillRectangle(g2d,w*i+1,canvasHeight/2-m,w-1,m);
                }
                if (m<0){
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                    AlgoVisHelper.fillRectangle(g2d,w*i+1,canvasHeight/2,w-1,-m);
                }
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


