/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void mark_parents(TreeNode root, Map<TreeNode,TreeNode> parent_track,TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parent_track.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track = new HashMap<>();
        mark_parents(root,parent_track,target);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level==k) break;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
            }
            curr_level++;
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }
}