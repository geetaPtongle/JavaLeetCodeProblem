package graph;

import java.util.*;

public class LargestPathValue {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<Integer>[] graph=new ArrayList[n];
        int[] indegree = new int[n +1];
        int[][] dp = new int[n][26];
        for(int i=0; i<n; i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge: edges){
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            indegree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
       int seen =0, ans=0;
        while (!q.isEmpty()){
            int u=q.poll();
            seen++;
            int colorIdx=colors.charAt(u)-'a';
            dp[u][colorIdx]++;
            ans = Math.max(ans, dp[u][colorIdx]);
            for(int v: graph[u]){
                for(int i=0; i<26; i++){
                    dp[v][i] = Math.max(dp[v][i], dp[u][i]);
                }
                if(--indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return seen==n?ans:-1;
    }
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},{0,2},{2,3},{3,4}
        };
        String colors = "abaca";
        LargestPathValue lp = new LargestPathValue();
        System.out.println(lp.largestPathValue(colors,edges));
    }
}
