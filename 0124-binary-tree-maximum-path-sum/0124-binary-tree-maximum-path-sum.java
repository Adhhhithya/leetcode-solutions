/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int max_val[] = new int[1];
        max_val[0] = Integer.MIN_VALUE;
        max_path_node(root,max_val);
        return max_val[0];
    }
    public int max_path_node(TreeNode root, int[] max_val){
        if(root==null){
            return 0;
        }
        int left_sum = Math.max(0,max_path_node(root.left,max_val));
        int right_sum = Math.max(0,max_path_node(root.right,max_val));
        max_val[0] = Math.max(max_val[0],left_sum+right_sum+root.val);
        return root.val + Math.max(left_sum,right_sum);
    }
}