package Maze;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {
    int[][] ch = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    // TODO: 创建自己的数据
    private MazeData mazeData;        // 数据
    private static int blockSide = 8;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(String filename){

        // 初始化数据
        // TODO: 初始化数据
         mazeData = new MazeData(filename);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", mazeData.getM()*blockSide, mazeData.getN()*blockSide);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        // TODO: 编写自己的动画逻辑
        pace(mazeData,1,-1);


    }
    public boolean pace(MazeData data,int x,int y){
        frame.render(mazeData);
        AlgoVisHelper.pause(5);
        if (x == data.getN()-2 && y == data.getM()-1){
            data.maze[x][y]=data.PACE;
            frame.render(mazeData);
            return true;
        }
        for (int i = 0 ; i<ch.length;i++){
            int newx = x+ch[i][0];
            int newy = y+ch[i][1];

            if (data.inArea(newx,newy) && data.getMaze(newx,newy)==MazeData.RODA){
                data.maze[newx][newy] = MazeData.PACE;
                if (pace(data,newx,newy)){
                    return true;
                }
                data.maze[newx][newy] = MazeData.RODA;
            }
        }
        return false;
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer("G:\\IDE\\Project\\AlgoGame\\src\\Maze\\maze_101_101.txt");
    }
}
