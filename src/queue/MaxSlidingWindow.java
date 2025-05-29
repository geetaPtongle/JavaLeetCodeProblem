package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        MaxSlidingWindow ms = new MaxSlidingWindow();
        int[] result = ms.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

//    TC: O(n-k)*k = O(kn- k2) = O(n*k) k<<<n
    public int[] maxSlidingWindow1(int[] nums, int k) {
       int n= nums.length;
        int max = Integer.MIN_VALUE;
        int[] ans= new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            max=nums[i];
            for(int j=i; j<k+i; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }
            ans[i] = max;
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val, int idx){
            this.val =val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Pair p2){
            //acending
            // return this.val-p2.val;
            //Decending
            return p2.val -this.val;
        }
    }

    //Using PriorityQueue Approach
    public int[] maxSlidingWindowUsingPriorityQue(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int[] res=new int[n-k+1];
        for(int i=0; i<k; i++){
            pq.add(new Pair(nums[i], i));
        }
        res[0] =pq.peek().val;
        for(int i=k; i<n; i++){
            while(pq.size()> 0 && pq.peek().idx <=(i-k)){
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            res[i-k+1] =pq.peek().val;
        }
        return res;
    }
}
