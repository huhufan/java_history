package SwingBase;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;
    private Circle[] circles;

    public void render(Circle[] circles){
        this.circles = circles;
        repaint();
    }


    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}



    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON));
            int stokeWidth = 3;
            AlgoVisHelper.setStrokeWidth(g2d,stokeWidth);
            AlgoVisHelper.setColor(g2d,Color.red);
            for (Circle c:circles){
                if (c.isFilled)
                    AlgoVisHelper.fillCircle(g2d,c.x,c.y,c.r);
                else
                    AlgoVisHelper.strokeCircle(g2d,c.x,c.y,c.r);


            }
        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
