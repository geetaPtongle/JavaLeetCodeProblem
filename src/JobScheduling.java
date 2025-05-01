import java.util.*;

public class JobScheduling {

    class The_Comparator implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            return list1.get(0) - list2.get(0); // Sort by endTime
        }
    }

    private int findMaxProfit(List<List<Integer>> jobs) {
        int n = jobs.size(), maxProfit = 0;

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new The_Comparator());

        for (int i = 0; i < n; i++) {
            int start = jobs.get(i).get(0);
            int end = jobs.get(i).get(1);
            int profit = jobs.get(i).get(2);

            while (!pq.isEmpty() && start >= pq.peek().get(0)) {
                maxProfit = Math.max(maxProfit, pq.poll().get(1));
            }

            ArrayList<Integer> combinedJob = new ArrayList<>();
            combinedJob.add(end);
            combinedJob.add(profit + maxProfit);
            pq.add(combinedJob);
        }

        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.poll().get(1));
        }

        return maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        int length = profit.length;

        for (int i = 0; i < length; i++) {
            ArrayList<Integer> job = new ArrayList<>();
            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);
            jobs.add(job);
        }

        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        return findMaxProfit(jobs);
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        JobScheduling solution = new JobScheduling();

        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        int result = solution.jobScheduling(startTime, endTime, profit);
        System.out.println("Maximum Profit: " + result);  // Output should be 120
    }
}
