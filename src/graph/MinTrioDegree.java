package graph;

public class MinTrioDegree {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degree = new int[n +1];
        int[][] connected = new int[n+1][n+1];
        for (int[] adj : edges) {
            int a = adj[0], b = adj[1];
            degree[a]++;
            degree[b]++;
            connected[a][b] = 1;
            connected[b][a] = 1;
        }
        int res=Integer.MAX_VALUE;
        for(int i=1; i<=n ; i++){
            for(int j=i+1; j<=n; j++){
                if (connected[i][j] == 0) continue;
                for(int k=j+1; k<=n; k++){
                    if (connected[i][k] == 1 && connected[j][k] == 1) {
                        int trioDegree = degree[i] + degree[j] + degree[k] - 6;
                        res = Math.min(res, trioDegree);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        MinTrioDegree mt = new MinTrioDegree();
        int[][] edges = {
                {1,2},{1,3},{3,2},{4,1},{5,2},{3,6}
        };

        int[][] edges2 = {
                {1,3},{4,1},{4,3},{2,5},{5,6},{6,7},{7,5},{2,6}
        };
        System.out.println(mt.minTrioDegree(6, edges));
        System.out.println(mt.minTrioDegree(7, edges2));
    }
}
