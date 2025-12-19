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
    private boolean is_mirror(TreeNode left, TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null|right==null) return false;
        if(left.val!=right.val) return false;

        return (is_mirror(left.left,right.right)&&is_mirror(left.right,right.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return is_mirror(root.left,root.right);
    }
}