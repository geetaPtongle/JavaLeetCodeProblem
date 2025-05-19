package greedy;

public class MinSum {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                count1++;
            }
            sum1 += nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 0) {
                count2++;
            }
            sum2 += nums2[i];
        }
        long new1 = sum1 + count1;
        long new2 = sum2 + count2;

        if (count1 == 0 && count2 == 0 && sum1 != sum2) return -1;
        if (count1 == 0 && new1 < new2) return -1;
        if (count2 == 0 && new2 < new1) return -1;

        return Math.max(new1, new2);
    }

    public static void main(String[] args) {
          int[] nums1 = {3,2,0,1,0}, nums2 = {6,5,0};
        MinSum ms = new MinSum();
        System.out.println(ms.minSum(nums1, nums2));
    }
}
