package greedy;

import java.util.Arrays;
import java.util.TreeMap;

public class MaxTaskAssign {
    public static int maxTaskAssign(
            int[] tasks,
            int[] workers,
            int pills,
            int strength
    ) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(
            int[] tasks,
            int[] workers,
            int pills,
            int strength,
            int mid
    ) {
        int p = pills;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; --i) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
            } else {
                if (p == 0) {
                    return false;
                }
                key = ws.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
                --p;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] task={3,2,1};
        int[] workers={0,3,3};
        int pills=1;
        int strength=1;
      System.out.println(maxTaskAssign(task, workers, pills, strength));
    }
}
