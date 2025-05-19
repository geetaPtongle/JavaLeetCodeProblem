package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {
        MaxLevelSum mls = new MaxLevelSum();
        Integer[] arr = {1, 7, 0, 7, -8, null, null};
        TreeNode root = buildTree(arr);
        System.out.println(mls.maxLevelSum(root));
    }

    public int maxLevelSum1(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(root);
        int currLevel = 1;
        while (!qe.isEmpty()) {
            int size = qe.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = qe.poll();
                sum += curr.val;
                if (curr.left != null) {
                    qe.offer(curr.left);
                }
                if (curr.right != null) {
                    qe.offer(curr.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }
            currLevel++;
        }
        return resultLevel;
    }

    Map<Integer, Integer> levelSum = new HashMap<>();



    public int maxLevelSum(TreeNode root) {
        levelSum.clear();
        dfs(root, 1);
        int resultLevel=0;
        int maxSum =Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: levelSum.entrySet()){
            int level= entry.getKey();
            int sum= entry.getValue();
            if(sum>maxSum){
                maxSum=sum;
                resultLevel= level;
            }
        }
        return resultLevel;
    }

    private void dfs(TreeNode root, int level) {
        if(root==null) return;
        levelSum.put(level, levelSum.getOrDefault(level, 0) + root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }


    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null)
            return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
