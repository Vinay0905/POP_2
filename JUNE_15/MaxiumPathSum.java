package JUNE_15;


// Approach: Use recursion on the binary tree.
// At each node, calculate best left and right gain and update global max path.


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}


public class MaxiumPathSum {
    

    static int maxSum = Integer.MIN_VALUE;
    // This starts max path sum calculation from the root.
    // The answer is stored in maxSum while recursion runs.
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
    // This returns the best one-side path gain from this node.
    // It also checks path passing through both children.
    public static int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftgain=Math.max(solve(root.left),0);
        int rightgain=Math.max(solve(root.right),0);
        int peeksum=root.val+leftgain+rightgain;
        maxSum=Math.max(maxSum,peeksum);
        return root.val+Math.max(leftgain,rightgain);
    }
    // This builds sample tree [1,2,3] and prints max path sum.
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
}
