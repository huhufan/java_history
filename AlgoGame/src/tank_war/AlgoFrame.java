package tank_war;

import java.awt.*;
import javax.swing.*;
import javax.xml.crypto.Data;

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
    private TankWarData data;
    public void render(TankWarData data){
        this.data = data;
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
            for(int i = 0 ; i < data.N(); i++){
               for (int j = 0 ; j< data.M() ; j++){
                   if(data.get(i,j)== 'B')
                       AlgoVisHelper.putImage(g2d,j*w,i*h,data.tankImgUrl(data.tank_status));
                   else{
                       if (data.get(i,j)== 'A')
                           AlgoVisHelper.putImage(g2d,j*w,i*h,data.bossImgUrl(data.get(i,j)));
                       if (data.get(i,j)== 'C')
                           AlgoVisHelper.putImage(g2d,j*w,i*h,data.bossImgUrl(data.get(i,j)));
                       if (data.get(i,j)== 'D')
                           AlgoVisHelper.putImage(g2d,j*w,i*h,data.bossImgUrl(data.get(i,j)));
                       if (data.get(i,j)== '0'&& data.isBullet[i][j])
                           AlgoVisHelper.putImage(g2d,j*w,i*h,"resource/tank_war/bullet.png");
                       else
                           AlgoVisHelper.putImage(g2d,j*w,i*h,data.roadImgUrl(data.get(i,j)));
                   }
               }
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


