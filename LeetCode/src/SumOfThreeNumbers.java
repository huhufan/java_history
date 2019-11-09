import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther hu  .
 * @create 2019/10/21
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class SumOfThreeNumbers {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i;
            int m = i + 1;
            int r = nums.length - 1;
            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(new Integer[]{nums[l], nums[m], nums[r]}));
                    m++;
                    r--;
                    while (m < r && nums[r] == nums[r + 1])
                        r--;
                    while (m < r && nums[m] == nums[m - 1])
                        m++;
                } else if (sum > 0) {
                    r--;
                    while (m < r && nums[r] == nums[r + 1])
                        r--;
                } else {
                    m++;
                    while (m < r && nums[m] == nums[m - 1])
                        m++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        new SumOfThreeNumbers().threeSum(ints);
    }

}
