import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @auther hu  .
 * @create 2019/10/25
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * https://leetcode-cn.com/problems/rectangle-area/
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int big_h = Math.max(B, F);
        int sm_h = Math.min(D, H);
        if (big_h > sm_h)
            return (C - A) * (D - B) + (G - E) * (H - F);
        int height = sm_h - big_h;
        int big_w = Math.max(A, E);
        int sm_w = Math.min(C, G);
        if (big_w > sm_w)
            return (C - A) * (D - B) + (G - E) * (H - F);
        int width = sm_w - big_w;
        return (C - A) * (D - B) + (G - E) * (H - F) - width * height;
    }
    public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(E>=C||G<=A||H<=B||F>=D) return (D-B)*(C-A)+(H-F)*(G-E);  //没有重合情况
        int mAreaWidth=Math.min(C,G)-Math.max(E,A);  //重合部分的宽
        int mAreaHeight=Math.min(H,D)-Math.max(B,F); //重合部分的高
        int sumArea=(D-B)*(C-A)+(H-F)*(G-E);   //总面积
        int mArea=mAreaWidth*mAreaHeight;
        return sumArea-mArea;
    }



    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
