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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorder_map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorder_map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorder_map);
        return root;
    }
    private TreeNode buildTree(
        int[] preorder,
        int pre_start,
        int pre_end,
        int[] inorder,
        int in_start,
        int in_end,
        Map<Integer,Integer> inorder_map
    ){
        if(pre_start>pre_end || in_start>in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        int in_root = inorder_map.get(root.val);
        int nums_left = in_root - in_start;
        
        root.left = buildTree(
            preorder,
            pre_start+1,
            pre_start+nums_left,
            inorder,
            in_start,
            in_root-1,
            inorder_map);
        root.right = buildTree(
            preorder,
            pre_start+nums_left+1,
            pre_end,
            inorder,
            in_root+1,
            in_end,
            inorder_map);
        return root;
    }
}