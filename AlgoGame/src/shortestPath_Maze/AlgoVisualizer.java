package shortestPath_Maze;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.HashSet;
import java.util.Set;

public class AlgoVisualizer {
    int[][] ch = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    // TODO: 创建自己的数据
    private MazeData data;        // 数据
    private static int blockSide = 8;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(String filename){

        // 初始化数据
        // TODO: 初始化数据
         data = new MazeData(filename);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", data.getM()*blockSide, data.getN()*blockSide);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        // TODO: 编写自己的动画逻辑
        Set<Point> set = new HashSet();
        set.add(new Point(1,0,null));
        data.maze[1][0] = MazeData.PATH;
        pace(set);
    }
    public void pace(Set<Point> set){
        Set<Point> set_new = new HashSet();
        for (Point point:set){
               sign_path(point,MazeData.PATH);
            for (int j=0;j<ch.length;j++){
                int newx = point.getX()+ch[j][0];
                int newy = point.getY()+ch[j][1];
                if (data.inArea(newx,newy) && data.getMaze(newx,newy) == MazeData.RODA){
                    data.maze[newx][newy] = MazeData.PACE;
                    Point pp = new Point(newx,newy,point);
                    set_new.add(pp);
                    if (newx == data.getN()-2 && newy == data.getM()-1){
                        data.maze[newx][newy] = MazeData.PATH;
                        sign_path(pp,MazeData.PATH);
                        frame.render(data);
                        AlgoVisHelper.pause(5);
                        return;
                    }
                    frame.render(data);
                    AlgoVisHelper.pause(5);
                }
            }
            sign_path(point,MazeData.PACE);
        }
        if (set.isEmpty())
            return;
        else{
            pace(set_new);
        }
    }
    private void sign_path(Point p,char c){
        Point s = p;
        while (s.getPre()!=null){
            data.maze[s.getX()][s.getY()] = c;
            s = s.getPre();
        }

    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer("G:\\IDE\\Project\\AlgoGame\\src\\Maze\\maze_101_101.txt");
    }
}
