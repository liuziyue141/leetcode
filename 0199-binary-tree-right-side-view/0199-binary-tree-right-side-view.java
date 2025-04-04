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
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println(queue.size());
            // System.out.println(queue.peekFirst().val);
            res.add(queue.peekFirst().val);
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.removeFirst();
                if(cur.right != null){
                    queue.addLast(cur.right);
                }

                if(cur.left != null){
                    queue.addLast(cur.left);
                }
            
            }
        }
        return res;
    }
}