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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        right_traverse(root,ans,0);
        return ans;
    }
    public static void right_traverse(TreeNode curr , List<Integer> res , int depth){
        if(curr==null){
            return;
        }
        if(depth==res.size()){
            res.add(curr.val);
        }
        right_traverse(curr.right,res,depth+1);
        right_traverse(curr.left,res,depth+1);
    }
}