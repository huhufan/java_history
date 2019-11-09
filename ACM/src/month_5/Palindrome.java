package month_5;


import javax.sound.midi.MidiChannel;
import java.util.Random;

public class Palindrome {
}

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
class Solution3 {
    public String longestPalindrome(String s) {
        if (s == null || s.length()<0) return "";
        int start = 0 , end = 0;
        for(int i = 0 ; i < s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len>end-start){
                start = i - (len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
      }

      private int expand(String s, int left , int right){
        int l = left , r = right;
        while (l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
      }

      public String manacher(String ss){
          System.out.println(ss);
        if (ss==null|| ss.length()==0) return "";
        // s= "ceabbata" -->>"!#c#e#a#b#b#a#a#a#a#a@"
          StringBuilder sb = new StringBuilder();
          int max_R_Mid = 0;
          int max_R = 1;
          sb.append("!#");
          for (int j = 0;j<ss.length();j++){
              sb.append(ss.charAt(j));
              sb.append("#");
          };
          sb.append("@");
          String s = sb.toString();
          System.out.println(s);
          int[] cur_R = new int[s.length()];
          int MID = 1;
          int R = 0;
          for (int i = 1 ; i < s.length()-1 ; i++){
              if (i < MID+R)
                  cur_R[i] = Math.min(cur_R[2*MID-i],MID+R-i);
              while ( s.charAt(i+cur_R[i]) == s.charAt(i-cur_R[i]) )
                  cur_R[i]++;
              if (i+cur_R[i] > MID+R){
                  if (cur_R[i] > max_R){
                      max_R = cur_R[i];
                      max_R_Mid = i;
                  }
                  MID = i;
                  R = cur_R[i];
              }
          }

          return s.substring(max_R_Mid-max_R+1,max_R_Mid+max_R).replace("#","");
      }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<1000000;i++){
            sb.append(r.nextInt(10));
        }
        Long st1 = System.nanoTime();
        System.out.println(s.manacher(sb.toString()));
        Long st2 = System.nanoTime();
        System.out.println((st2-st1)/1000000);

        long st3 = System.nanoTime();
        System.out.println(s.longestPalindrome(sb.toString()));
        Long st4 = System.nanoTime();
        System.out.println((st4-st3)/1000000);


    }
}