package Sort.SelectedSorted;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {

    // TODO: 创建自己的数据
    private SortData sortData;
    private int N;
    public int sorted = -1;
    public int curMin = -1;
    public int curComp = -1;
    // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight,int n){

        // 初始化数据
        // TODO: 初始化数据
        this.N = n;
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = (int) (Math.random()*(sceneHeight-50)+1);
        }
        sortData = new SortData(n,arr);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            // TODO: 根据情况决定是否加入键盘鼠标事件监听器
            new Thread(() -> {
                run();
            }).start();
        });
    }
    private void view(int sorted,int curMin,int curComp){
        this.sorted = sorted;
        this.curComp = curComp;
        this.curMin = curMin;
        frame.render(sortData,sorted,curComp,curMin);
        AlgoVisHelper.pause(5);
    }

    // 动画逻辑
    private void run(){
        view(-1,-1,-1);
        // TODO: 编写自己的动画逻辑
        for (int i = 0;i<sortData.length();i++){
            int minIndex = i;
            for (int j = i+1;j<sortData.length();j++){
                view(i,minIndex,j);
                if (sortData.get(minIndex)>sortData.get(j))
                    minIndex = j;
            }
            sortData.swap(i,minIndex);
        }
        view(sortData.length(),-1,-1);
    }

    // TODO: 根据情况决定是否实现键盘鼠标等交互事件监听器类
    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight,100);
    }
}
