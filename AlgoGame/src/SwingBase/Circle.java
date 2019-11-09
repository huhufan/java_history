package SwingBase;

import java.awt.*;

public class Circle {
    double x;
    double y;
    double r;

    double vx;
    double vy;
    boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }
    public void move(int xmin,int xmax,int ymin,int ymax){
        x += vx;
        y += vy;
        checkCollision(xmin,xmax,ymin,ymax);

    }
    private void checkCollision(int xmin,int xmax,int ymin,int ymax){
        if (x+r>=xmax){ x = xmax-r;      vx = -vx; }
        if (x-r<=xmin){ x = xmin+r;      vx = -vx; }
        if (y+r>=ymax){ y = ymax-r;      vy = -vy; }
        if (y-r<=ymin){ y = ymin+r;      vy = -vy; }
    }
    public boolean isPress(Point p){
        return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y) <= r*r;
    };
    static void checkImpact(Circle[] circles){
        for (int i=0;i<circles.length;i++){
            for (int j=i+1;j<circles.length;j++){
               Circle c = circles[i];
                Circle cc = circles[j];
                if ((Math.pow((c.x-cc.x),2)+Math.pow((c.y-cc.y),2)<=Math.pow((c.r+cc.r),2))){
//                    double k = (c.y-cc.y)/(c.x-cc.x);
//                    double x = c.x-Math.sqrt(Math.pow((c.r+cc.r),2)/(1+k));
//                    double y = c.y-k*(c.x-x);
//                    c.x = (int) x;
//                    c.y = (int) y;
                    c.vx = -c.vx;
                    c.vy = -c.vy;
                    cc.vx = -cc.vx;
                    cc.vy = -cc.vy;
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
