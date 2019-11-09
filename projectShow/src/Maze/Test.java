package Maze;

public class Test {
    public static void main(String[] args) {
//        MazeData maze = new MazeData("G:\\IDE\\Project\\AlgoGame\\src\\Maze\\maze_101_101.txt");
//        maze.print();
        int[] a1 = {1,5,8,1};
        int[] a2 = {5,7,9,2};
        int[] a3 = {6,8,6,3};

        int[][] b = new int[3][];
        b[0] = a1;
        b[1] = a2;
        b[2] = a3;

        System.out.println(b[1][2]);

    }
}
