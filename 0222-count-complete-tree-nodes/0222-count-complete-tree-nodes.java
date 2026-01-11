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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l = get_left_height(root);
        int r = get_right_height(root);
        if(l==r){
            return ((2<<(l))-1);
        }else{
            return 1 + countNodes(root.left) +countNodes(root.right);
        }
    }
    public static int get_left_height(TreeNode root){
        int cnt=0;
        while(root.left!=null){
            cnt++;
            root=root.left;
        }
        return cnt;
    }
    public static int get_right_height(TreeNode root){
        int cnt=0;
        while(root.right!=null){
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}