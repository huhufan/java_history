package tank_war;

import sun.dc.pr.PRError;

import java.awt.*;

public class Bullet {
    private Point point;
    private int number;
    private int direction;
    private int rate;

    public Bullet(Point point, int number, int direction,int rate) {
        this.point = point;
        this.number = number;
        this.direction = direction;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
