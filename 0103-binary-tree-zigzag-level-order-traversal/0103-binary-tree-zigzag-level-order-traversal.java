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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        int level = 0;
        List<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curNode = queue.remove(0);
                if(level%2==0){
                    cur.add(curNode.val);
                }else{
                    cur.add(0, curNode.val);
                }

                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            level++;

            res.add(cur);
        }
        return res;
    }
}