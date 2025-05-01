package array;


import java.util.HashMap;
import java.util.Map;

class MostFrequent {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n=nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                int followingKey = nums[i + 1];
                map.put(followingKey, map.getOrDefault(followingKey, 0) + 1);
            }
        }
        int freq = Integer.MIN_VALUE;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > freq) {
                ans = entry.getKey();
                freq = entry.getValue();
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        MostFrequent sol = new MostFrequent();
        int[] nums = {1,100,200,1,100};
        System.out.println(sol.mostFrequent(nums, 1));
    }
}