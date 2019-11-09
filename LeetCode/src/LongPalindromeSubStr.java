/**
 * @auther hu  .
 * @create 2019/10/4
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongPalindromeSubStr {

    //中心扩展
    // a|b|c|c|b|a  2n-1个中心（字母本身+字母与字母之接间隔）
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int exp1 = expandFromCenter(s, i, i); // wcabbacs   i=3  exp = 6
            int exp2 = expandFromCenter(s, i, i + 1);//wcabacs i=3  exp = 5
            int len = Math.max(exp1, exp2);
            if (len > end - start) { //得到更长的回文子串
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int L, int R) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //*********************************************************************************************
    public String longestPalindrome2(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        //处理原始s   eg: sada-->*s*a*d*a*
        String str = preStr(s);
        //当前最右的回文串的中心点
        int C = -1;
        //当前最右的回文串的半径
        int R = -1;
        //记录半径的数组
        int[] radius = new int[str.length()];
        //当前最长回文串的中心索引
        int max_index = 0;
        for (int N = 0; N < str.length(); N++) {
            //如果当前索引在最右回文串的范围内，即N < C + R，根据C-(N-C)=2*C-N得到N对于C的对称点；
            //如果对于中心点为2*C-N的回文串也在最右回文串的范围内，则N与2*C-N的情况是一样的，radius[N]赋值为radius[2 * C - N]；
            //如果对于中心点为2*C-N的回文串超出最右回文串的范围内，则N与2*C-N只能说部分情况一样，2*C-N超出最右回文串的范围无法估计，
            //   只能取到范围边界，radius[N]赋值为C + R - N + 1；
            //如果当前索引不在最右回文串的范围内，radius[N]赋值为1；
            radius[N] = N < C + R ? Math.min(radius[2 * C - N], C + R - N + 1) : 1;
            //当前索引对应的字符从根据radius[N]半径值从两边扩展延伸；
            while (N + radius[N] < str.length() && N - radius[N] >= 0) {
                //如果N + radius[N]与N - radius[N]对应的字符相等，说明一次扩展成功，半径++；
                if (str.charAt(N + radius[N]) == str.charAt(N - radius[N]))
                    radius[N]++;
                    //如果不匹配，当前回文串不必再延伸下去，直接break;
                else
                    break;
            }
            //如果当前索引N的回文右边界比原来的最右回文右边界更靠右，则更新最右回文串的特征变量C、N;
            if (N + radius[N] - 1 > C + R) {
                C = N;
                R = radius[N] - 1;
            }
            //如果当前N对应的回文串的半径大于最长回文串的半径，则更新最长回文串的特征变量max_index
            if (radius[N] >= radius[max_index])
                max_index = N;
        }
        //根据最长回文串的中心索引max_index以及其对于的半径值radius[max_index]得到最长回文串，通过finStr()去除辅助的'#'号,得到最终返回的结果
        return finStr(str.substring(max_index - radius[max_index] + 1, max_index + radius[max_index]));
    }

    // 负责去除字符串中多余的'#'号
    private String finStr(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#')
                builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    //负责给原始字符串的间隙添加'#'号
    private String preStr(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append('#');
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            builder.append('#');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongPalindromeSubStr().longestPalindrome2("eabebaf"));
    }
}
