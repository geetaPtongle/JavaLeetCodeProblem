package bfs;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        boolean[] ans=new boolean[]{true};
        TreeNode[] prev = new TreeNode[1];
        inorderTraversal(root, prev, ans);
        return ans[0];
    }

    public void inorderTraversal(TreeNode root,TreeNode[] prev, boolean[] ans){
        if(root==null) return;
        inorderTraversal(root.left, prev, ans);
        if(prev[0] != null){
            if(prev[0].val >= root.val) {
                ans[0]=false;
                return;
            }
        }
        prev[0]=root;
        inorderTraversal(root.right,prev, ans);
    }

    public static void main(String[] args) {
        // Example 1: Valid BST
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        IsValidBST sol = new IsValidBST();
        System.out.println("Is Valid BST? " + sol.isValidBST(root1)); // Output: true

        // Example 2: Invalid BST
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Is Valid BST? " + sol.isValidBST(root2)); // Output: false
    }
}
