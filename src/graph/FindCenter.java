package graph;

public class FindCenter {
    public static int findCenter(int[][] edges) {
        // The center will appear in both of the first two edges
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
    public static void main(String[] args) {
        FindCenter fc = new FindCenter();
        int[][] edges = {   {5, 1},
                {2, 5},
                {5, 3},
                {5, 4},
                {6, 5},
                {7, 5},
                {5, 8},
                {9, 5},
                {5, 10},
                {11, 5}};
        System.out.println(fc.findCenter(edges));
        int center = fc.findCenter(edges);
        int n=edges.length;
        for (int i = 0; i < n; i++) {
            if (i != center) {
                edges[center][i] = 1;
                edges[i][center] = 1;
            }
        }

        // Print matrix
        System.out.println("Adjacency Matrix of Star Graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }


    }
}
