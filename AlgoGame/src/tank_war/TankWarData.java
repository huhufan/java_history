package tank_war;

import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TankWarData {

    private char[][] map;
    public int tank_status = 0;  // 0 正方向  1 右  2 下  3 左
    private int N ,M;
    public Point my_tank_place;
    public Set<Bullet> bullets;
    public boolean isBullet[][];

    public String  roadImgUrl(char c){
        String s = "resource/tank_war/road"+c+".png";
        return s;
    }
    public String  tankImgUrl(int c){
        String s = "resource/tank_war/tank"+c+".png";
        return s;
    }
    public String  bossImgUrl(char c){
        String s = "resource/tank_war/boss"+c+".png";
        return s;
    }
    public char get(int x,int y){
        if (!inArea(x,y))
            throw new IllegalArgumentException("x or y is not Illegal");
        return map[x][y];
    }
    public boolean inArea(int x,int y){
        return x >= 0 && x < N && y >= 0 && y <M;
    }

    public TankWarData(String filename){
        bullets = new HashSet<>();
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
            map = new char[N][M];
            isBullet = new boolean[N][M];
            for (int i = 0 ; i < N ; i ++ ){
                String line = s.nextLine();
                if (line.length()!=2*M-1)
                    throw new IllegalArgumentException("Maze file is not illegal");
                for (int j = 0 ;j < M ; j ++ ){
                    char c = line.charAt(j*2);
                    map[i][j] = c;
                    if (c == 'B')
                        my_tank_place = new Point(i,j);
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
    public void myTankMove(int direction){
        int a[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        tank_status = direction;
        int nx = my_tank_place.x+a[direction][0];
        int ny = my_tank_place.y+a[direction][1];
        if (inArea(nx,ny) && get(nx,ny)=='0'){
            swap(my_tank_place.x,my_tank_place.y,nx,ny);
            my_tank_place = new Point(nx,ny);
        }
    }
    public void addBullet(){
        Bullet b = new Bullet(new Point(my_tank_place.x,my_tank_place.y),1,tank_status,1);
        if (!bullets.isEmpty())
            return;
        bullets.add(b);
    }
    public void buffetMove(){
        int a[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        for ( Bullet b:bullets){
            int dir = b.getDirection();
            isBullet[b.getPoint().x][b.getPoint().y] = false;
            int nx = b.getPoint().x+a[dir][0]*b.getRate();
            int ny = b.getPoint().y+a[dir][1]*b.getRate();
            if (!inArea(nx,ny)){
                bullets.remove(b);
                continue;
            }
            else{
                if (get(nx,ny)== '0'|| get(nx,ny)== 'C'){
                    b.setPoint(new Point(nx,ny));
                    isBullet[nx][ny] = true;
                }
                else if (get(nx,ny)!='A' && get(nx,ny)!='B'){
                    map[nx][ny] = (char) (Integer.valueOf(map[nx][ny])-1);
                    bullets.remove(b);
                }
                else if ( get(nx,ny)=='A'){
                    map[nx][ny] = 'C';
                    bullets.remove(b);
                }

            }

        }
    }
    private void swap(int x,int y,int nx,int ny){
        char c = get(x,y);
        map[x][y] = map[nx][ny];
        map[nx][ny] = c;
    }

    public int N() {
        return N;
    }

    public int M() {
        return M;
    }

    public void print(){
        System.out.println(N +"  "+M);
        for (int i = 0;i < N; i++){
            for (int j = 0 ; j < M ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TankWarData data = new TankWarData("resource/tank_war/tank1.txt");
    }
}
