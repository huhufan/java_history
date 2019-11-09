import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @auther hu  .
 * @create 2019/10/23
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationOfNumbers {
    List<String> list = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0)
            return list;
        letter(digits, 0, "");
        return list;
    }

    private void letter(String digits, int i, String s) {
        if (i == digits.length()) {
            list.add(s);
            return;
        }
        char c = digits.charAt(i);
        String sc = map.get(c);
        for (int j = 0; j < sc.length(); j++) {
            letter(digits, i + 1, s + sc.charAt(j));
        }
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombinationOfNumbers().letterCombinations("236");
        for (String s : list)
            System.out.println(s);
    }
}
