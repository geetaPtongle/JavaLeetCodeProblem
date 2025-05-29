package graph;

import java.util.*;

public class MaxTargetNodes {
    private int bfs(int curr, Map<Integer, List<Integer>> adj, int d, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{curr, 0});
        boolean[] visited = new boolean[N];
        visited[curr] = true;

        int count = 0; // count the target nodes
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int currNode = pair[0];
            int dist = pair[1];

            if (dist > d) {
                continue;
            }

            count++; // include current node in targetNodes count

            for (int neighbor : adj.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return count;
    }

    private int[] findCount(int[][] edges, int d) {
        int N = edges.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // result[i] = bfs(i, adj, d, N);
            result[i] = dfs(i, adj, d, -1);
        }

        return result;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int N = edges1.length + 1;

        int[] result1 = findCount(edges1, k);     // From tree1 within distance k
        int[] result2 = findCount(edges2, k - 1); // From tree2 within distance k-1

        int maxTargetNodesCount = Arrays.stream(result2).max().getAsInt();

        for (int i = 0; i < N; i++) {
            result1[i] += maxTargetNodesCount;
        }

        return result1;
    }

    private int dfs(int curr, Map<Integer, List<Integer>> adj, int d, int parent) {
        if (d < 0) return 0;

        int count = 1; // count current node

        for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
            if (neighbor != parent) {
                count += dfs(neighbor, adj, d - 1, curr);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        MaxTargetNodes mt = new MaxTargetNodes();
        int[][] edges1 = {
                {0,1},{0,2},{2,3},{2,4}
        };
        int[][] edges2 = {
                {0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}
        };
        int[] res = mt.maxTargetNodes(edges1, edges2, 2);
        for(int i: res){
            System.out.print(i+" ");
        }
    }
}
