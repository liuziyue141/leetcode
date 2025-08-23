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
    public List<List<Integer>> findLeaves(TreeNode root) {
        boolean stop = false;
        List<List<Integer>> res = new ArrayList<>();
        while(!stop){
            List<Integer> l = new ArrayList<>();
            stop = findLeave(root, null, l);
            res.add(l);
        }
        return res;
    }

    public boolean findLeave(TreeNode cur, TreeNode parent, List<Integer> leaves){
        if(cur == null){
            return false;
        }
        if(cur.left == null && cur.right == null){
            leaves.add(cur.val);
            if(parent == null){
                return true;
            }
            if(cur == parent.left){
                parent.left = null;
            }
            if(cur == parent.right){
                parent.right = null;
            }
            return false;
        }
        findLeave(cur.right, cur, leaves);
        findLeave(cur.left, cur, leaves);
        return false;
    }
}