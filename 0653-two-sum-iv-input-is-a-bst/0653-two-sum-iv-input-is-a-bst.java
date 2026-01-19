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
class BST_Iterator{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;

    public BST_Iterator(TreeNode root,boolean is_reverse){
        reverse=is_reverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next(){
        TreeNode temp = st.pop();
        if(reverse==false) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

    public void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse==true){
                node=node.right;
            }else{
                node=node.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BST_Iterator l = new BST_Iterator(root,false);
        BST_Iterator r = new BST_Iterator(root,true);
        int i=l.next();
        int j = r.next();

        while(i<j){
            if((i+j)==k) return true;
            else if((i+j)<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}