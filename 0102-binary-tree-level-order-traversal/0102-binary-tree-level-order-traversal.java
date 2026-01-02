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
    public List<List<Integer>> levelOrder(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       List<List<Integer>>list = new LinkedList<List<Integer>>();
       if(root==null){
        return list;
       }
       q.add(root);
       while(!q.isEmpty()){
        int size = q.size();
        List<Integer> sub_list = new LinkedList<Integer>();
        for(int i=0;i<size;i++){
            if(q.peek().left!=null){
                q.add(q.peek().left);
            }
            if(q.peek().right!=null){
                q.add(q.peek().right);
            }
            sub_list.add(q.poll().val);
        }
        list.add(sub_list);
       }
       return list;
    }
}