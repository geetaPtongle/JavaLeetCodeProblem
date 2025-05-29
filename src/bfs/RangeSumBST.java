package bfs;

public class RangeSumBST {


    //Using Inorder BSF
    public int rangeSumBST1(TreeNode root, int low, int high) {
        int[] sum = new int[]{0};
        solve(root, low, high, sum);
        return sum[0];
    }

    public void solve(TreeNode root, int low, int high, int[] sum) {
        if(root ==null) return;
        solve(root.left, low, high, sum);
        if(low <=root.val &&  root.val<=high){
            sum[0] +=root.val;
        }
        solve(root.right, low, high, sum);
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(low> root.val) return rangeSumBST(root.right, low, high);
        else if(high<root.val) return rangeSumBST(root.left, low, high);
        else return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }

    public static void main(String[] args) {
        // Construct the tree manually for: [10,5,15,3,7,null,18]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(root, low, high));
    }
}
