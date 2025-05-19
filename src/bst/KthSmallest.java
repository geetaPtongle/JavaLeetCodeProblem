package bst;

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1]; // count[0] to track current count
        int[] ans = new int[1];   // ans[0] to store the answer
        helper(root, k, count, ans);
        return ans[0];
    }

    private static void helper(TreeNode root, int k, int[] count, int[] ans) {
        if (root == null) return;

        helper(root.left, k, count, ans);

        count[0]++;
        if (count[0] == k) {
            ans[0] = root.val;
            return;
        }

        helper(root.right, k, count, ans);
    }

    public static void main(String[] args) {
        // Construct the BST:
        //         5
        //        / \
        //       3   6
        //      / \
        //     2   4
        //    /
        //   1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3; // Find the 3rd smallest element

        int result = kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }
}
