package shortestPath_Maze;

public class Point {
    private int x,y;
    private Point pre;

    public Point(int x, int y, Point pre) {
        this.x = x;
        this.y = y;
        this.pre = pre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getPre() {
        return pre;
    }

    public void setPre(Point pre) {
        this.pre = pre;
    }
}
