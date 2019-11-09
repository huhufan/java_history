package Maze;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MazeData {
    public static final char RODA = ' ';
    public static final char WALL = '#';
    public static final char PACE = '0';



    private int N,M;
     char[][] maze;

    public MazeData(String filename){
        if (filename==null)
            throw new IllegalArgumentException("filename can not be null");
        Scanner s = null;
        try{
            File file = new File(filename);
            if (!file.exists())
                throw new IllegalArgumentException("file is not exist");
            FileInputStream fis = new FileInputStream(file);
            s= new Scanner(new BufferedInputStream(fis),"UTF-8");

            //读取第一行
            String nmLine = s.nextLine();
            String[] nm = nmLine.trim().split("\\s+");
            N = Integer.valueOf(nm[0]);
            M = Integer.valueOf(nm[1]);
            maze = new char[N][M];
            for (int i = 0 ; i < N ; i ++ ){
                String line = s.nextLine();
                if (line.length()!=M)
                    throw new IllegalArgumentException("Maze file is not illegal");
                for (int j = 0 ;j < M ; j ++ ){
                    maze[i][j] = line.charAt(j);
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (s!=null)
                s.close();
        }
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public char getMaze(int i,int j){
        if (!inArea(i,j))
            throw new IllegalArgumentException("i or j is not illegal ");
        return maze[i][j];

    }
    public boolean inArea(int x,int y){
        return x >= 0 && x < N && y >= 0 && y <M;
    }

    public void print(){
        System.out.println(N +"  "+M);
        for (int i = 0;i < N; i++){
            for (int j = 0 ; j < M ; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
