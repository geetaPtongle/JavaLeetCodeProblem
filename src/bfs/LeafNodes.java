package bfs;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = right = null;
    }
}

public class LeafNodes {
    public ArrayList<Integer> leafNodesWithStack(int[] preorder) {
        // code here
        Stack<Integer> stk = new Stack<>();
        int n = preorder.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (stk.isEmpty()) stk.push(preorder[i]);
            else {
                if (stk.peek() < preorder[i]) {
                    int storage = stk.peek();
                    int counter = 0;
                    while (!stk.isEmpty() && stk.peek() < preorder[i]) {
                        counter++;
                        stk.pop();
                    }
                    if (counter >= 2) {
                        res.add(storage);
                    }
                }
                stk.push(preorder[i]);
            }
        }
        if (!stk.isEmpty()) res.add(stk.peek());
        return res;
    }

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> leafNodes(int[] preorder) {
        int n = preorder.length;
        int inOrder[] = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = preorder[i];
        }
        Arrays.sort(inOrder);
        Node root = helper(0, 0, n-1, preorder, inOrder);
        printLeafNode(root);
        return res;
    }

    public void printLeafNode(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if (root.left != null) {
            printLeafNode(root.left);
        }
        if (root.right != null) {
            printLeafNode(root.right);
        }
    }

    public Node helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 ||  inStart> inEnd) return null;
        int inIndex=0;
        Node root = new Node(preorder[preStart]);
        for(int i=inStart; i<=inEnd; i++){
            if(root.val == inorder[i])
                inIndex=i;
        }
        root.left= helper(preStart+1, inStart, inIndex-1, preorder,inorder);
        root.right=helper(preStart+1+inIndex-inStart, inIndex+1, inEnd,preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        LeafNodes leafNodes = new LeafNodes();
        int[] preorder = {4, 2, 1, 3, 6, 5};
        System.out.println(leafNodes.leafNodes(preorder));
    }
}
