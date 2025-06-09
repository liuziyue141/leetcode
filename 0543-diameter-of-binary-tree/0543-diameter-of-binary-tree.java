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
    int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxLen;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxLen = Math.max(left + right + 2, maxLen);
        return Math.max(left, right) + 1; 
    }
}