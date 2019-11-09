package Mine_Sweeper;

import java.awt.*;
import javax.swing.*;

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
    private MineSweeperData data;
    private boolean fail = false;

    public void render(MineSweeperData data,boolean fail){
        this.data = data;
        this.fail = fail;
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
            int w = canvasWidth/data.M();
            int h = canvasHeight/data.N();
            for (int i = 0 ; i < data.N() ; i++){
                for (int j = 0 ; j < data.M() ; j++){
                    if (data.open[i][j]){
                        if (data.isMine(i,j))
                            AlgoVisHelper.putImage(g2d,j*w,i*h,MineSweeperData.mineUrl);
                        else
                            AlgoVisHelper.putImage(g2d,j*w,i*h,MineSweeperData.numberUrl(data.getNumber(i,j)));
                    }
                    else{
                        if (data.flags[i][j])
                            AlgoVisHelper.putImage(g2d,j*w,i*h,MineSweeperData.flagUrl);
                        else{
                            AlgoVisHelper.putImage(g2d,j*w,i*h,MineSweeperData.blockUrl);
                        }
                    }
                }
            }
            if (fail){
                AlgoVisHelper.setColor(g2d,AlgoVisHelper.Pink);
                AlgoVisHelper.drawText(g2d,"GAME OVER",canvasWidth/2,canvasHeight/2);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


