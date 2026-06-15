package JUNE_15;




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
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
}
