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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int cur){
        cur = cur * 10 + root.val;
        int sum = 0;
        if(root.left != null){
            sum += sumNumbers(root.left, cur);
        }
        if(root.right != null){
            sum += sumNumbers(root.right, cur);
        }
        if(root.right == null && root.left == null){
            return cur;
        }
        return sum; 
    }
}