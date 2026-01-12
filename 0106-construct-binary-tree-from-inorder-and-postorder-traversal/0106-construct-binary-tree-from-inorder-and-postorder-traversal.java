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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorder_map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorder_map.put(inorder[i],i);
        }
        TreeNode root = buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inorder_map);
        return root;
    }
    private TreeNode buildTree(
        int[] inorder,
        int in_start,
        int in_end,
        int[] postorder,
        int post_start,
        int post_end,
        Map<Integer,Integer> inorder_map
    ){
        if(post_start>post_end || in_start>in_end) return null;
        TreeNode root = new TreeNode(postorder[post_end]);
        int in_root = inorder_map.get(root.val);
        int nums_left = in_root - in_start;
        
        root.left = buildTree(
            inorder,
            in_start,
            in_root-1,
            postorder,
            post_start,
            post_start+nums_left-1,
            inorder_map);
        root.right = buildTree(
            inorder,
            in_root+1,
            in_end,
            postorder,
            post_start+nums_left,
            post_end-1,
            inorder_map);
        return root;
    }
}