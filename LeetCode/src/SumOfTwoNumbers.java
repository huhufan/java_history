import java.util.HashMap;
import java.util.HashSet;

/**
 * @auther hu  .
 * @create 2019/10/1
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class SumOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] =map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] twoSum = new SumOfTwoNumbers().twoSum(nums, 6);
        System.out.println(twoSum[0]+","+twoSum[1]);
    }
}

