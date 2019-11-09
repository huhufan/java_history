package Mine_Sweeper;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {
    private static int DELAY = 20;
    private static int LOCK_SIDE = 32;

    private MineSweeperData data;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int N, int M,int mineNumber){

        // 初始化数据
        data = new MineSweeperData(N,M,mineNumber);
        int sceneWidth = M*LOCK_SIDE;
        int sceneHeight = N*LOCK_SIDE;
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        setData(false,-1,-1);

    }
    private void setData(boolean isLeftClicked,int x,int y){
        if (data.inArea(x,y)){
            if (isLeftClicked){
                if (!data.isMine(x,y)){
                    data.open(x,y);
                }
                else{
                    data.open[x][y] = true;
                    data.openAll();
                    frame.render(data,true);
                    AlgoVisHelper.pause(DELAY);
                    return;
                }
            }
            else
                data.flags[x][y] = !data.flags[x][y];
        }
        frame.render(data,false);
        AlgoVisHelper.pause(DELAY);
    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent event){
            event.translatePoint(-(int)(frame.getBounds().width-frame.getCanvasWidth()),-(int)(frame.getBounds().height-frame.getCanvasHeight()));
            Point pos = event.getPoint();

            int w = frame.getCanvasWidth() / data.M();
            int h = frame.getCanvasHeight() / data.N();

            int x = pos.y/h;
            int y = pos.x/w;
            if (SwingUtilities.isLeftMouseButton(event))
                setData(true,x,y);
            else
                setData(false,x,y);
        }
    }

    public static void main(String[] args) {
        AlgoVisualizer visualizer = new AlgoVisualizer(10, 10,10);
    }
}
