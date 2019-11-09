import java.util.HashMap;
import java.util.HashSet;

/**
 * @auther hu  .
 * @create 2019/10/2
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class NonRepeLongSubStr {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0; //左
        int j = 0; //右
        int n = s.length();
        HashSet<Character> set = new HashSet();

        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)))
                i = Math.max(map.get(s.charAt(j)), i);
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
