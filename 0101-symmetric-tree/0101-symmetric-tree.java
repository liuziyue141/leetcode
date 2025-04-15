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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);

        while(left.size()>0){
            TreeNode leftNode = left.peek();
            TreeNode rightNode = right.peek();

            if(leftNode == null && rightNode == null){
                left.pop();
                right.pop();
            }else if(leftNode == null && rightNode != null){
                return false;
            }else if(rightNode == null && leftNode != null){
                return false;
            }else if(rightNode.val != leftNode.val){
                return false;
            }else{
                left.pop();
                right.pop();
                left.push(leftNode.left);
                right.push(rightNode.right);
                left.push(leftNode.right);
                right.push(rightNode.left);
            }
        }
        return true;
    }
}