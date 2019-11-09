/**
 * @auther hu  .
 * @create 2019/10/25
 */
public class FindMidNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length + nums2.length];
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                a[i] = nums1[n1];
                n1++;
            } else {
                a[i] = nums2[n2];
                n2++;
            }
            i++;
        }
        if (n1 == nums1.length)
            for (int j = n2; j < nums2.length; j++) {
                a[i] = nums2[j];
                i++;
            }
        else
            for (int j = n1; j < nums1.length; j++) {
                a[i] = nums1[j];
                i++;
            }
        if (a.length % 2 != 0)
            return a[a.length / 2];
        else
            return (a[a.length / 2] + a[a.length / 2 - 1]) / 2.0;

    }

    private double findMedianSortedArrays(int[] a, int[] b, int L, int R) {
        int i = (L + R) / 2;
        int j = (a.length + b.length) / 2;
        if (0 < i && i < a.length) {
            if (0 < j && j < b.length) {

            }
        }
        return 1;
    }

    public static void main(String[] args) {
        new FindMidNum().findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }
}
