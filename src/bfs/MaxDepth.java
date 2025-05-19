package bfs;

public class MaxDepth {
    static int height = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        height = Math.max(lh, rh) + 1;
        return height;
    }


    public static void main(String[] args) {
        // Sample Tree:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("<Maximum Height of Binary Tree>:");
        System.out.println(maxDepth(root));
    }
}
