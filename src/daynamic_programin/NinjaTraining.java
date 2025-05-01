package daynamic_programin;

class NinjaTraining {
    // Recursive function without memoization
    static int f(int day, int last, int[][] points) {
        // Base case: When it's the first day (day == 0)
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return maxi;
        }

        int maxi = 0;
        // Loop through the three activities on the current day
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                // Calculate the points for the current activity and recursively
                // calculate the maximum points for the previous day
                int activity = points[day][i] + f(day - 1, i, points);
                maxi = Math.max(maxi, activity);
            }
        }

        return maxi;
    }

    // Function to find the maximum points for ninja training
    static int ninjaTraining(int n, int[][] points) {
        // Start the recursive calculation from the last day (n - 1) with the last activity (3)
        return f(n - 1, 3, points);
    }

    public static void main(String args[]) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
