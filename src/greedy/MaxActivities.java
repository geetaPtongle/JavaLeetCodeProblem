package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxActivities {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8};
        int[] end = {2, 4, 6, 7, 9};
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }


        unSortedActivities(start, end);
        System.out.println(activitySelection(start, end));

    }

    public static void unSortedActivities(int[] start, int[] end) {
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; //storing index of activities
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;

        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("max activities: " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("A" + ans.get(i) + "");
        }
    }

    static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int ans = 0;

        // Store activities as (finish, start) pairs
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = finish[i];
            arr[i][1] = start[i];
        }

        // Sort activities based on finish time
        Arrays.sort(arr,(a, b) -> Integer.compare(a[0], b[0]));

        // To store the end time of last activity
        int finishtime = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > finishtime) {
                finishtime = arr[i][0];
                ans++;
            }
        }
        return ans;
    }

}
