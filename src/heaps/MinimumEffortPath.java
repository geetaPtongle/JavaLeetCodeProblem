package heaps;


import java.util.PriorityQueue;
class Node implements Comparable<Node> {
    int row, col, effort;

    Node(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

    @Override
    public int compareTo(Node other) {
        return this.effort - other.effort;
    }
}
public class MinimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int r = node.row;
            int c = node.col;
            int effort = node.effort;

            if (r == row - 1 && c == col - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col) {
                    int currentEffort = Math.abs(heights[nr][nc] - heights[r][c]);
                    int maxEffort = Math.max(currentEffort, effort);

                    if (maxEffort < dist[nr][nc]) {
                        dist[nr][nc] = maxEffort;
                        pq.offer(new Node(nr, nc, maxEffort));
                    }
                }
            }
        }

        return 0; // fallback (though this line is practically never reached)
    }
    public static void main(String[] args) {
        MinimumEffortPath sol = new MinimumEffortPath();
        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int result = sol.minimumEffortPath(heights);
        System.out.println("Minimum Effort: " + result);
    }
}
