package bfs;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomView {
    class Pair {
        int level;
        int data;

        Pair(int level, int data) {
            this.level = level;
            this.data = data;
        }
    }

    // Helper method (recursive DFS)
    public void helper(Node root, int dist, int level, TreeMap<Integer, Pair> map) {
        if (root == null) return;

        if (!map.containsKey(dist) || map.get(dist).level <= level) {
            map.put(dist, new Pair(level, root.val));
        }

        helper(root.left, dist - 1, level + 1, map);
        helper(root.right, dist + 1, level + 1, map);
    }

    // Main method to get bottom view
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Pair> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root, 0, 0, map);

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            ans.add(entry.getValue().data);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Sample binary tree construction
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        BottomView tree = new BottomView(); // Or your class name containing bottomView method
        ArrayList<Integer> result = tree.bottomView(root);

        // Print the bottom view
        System.out.println("Bottom View:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
