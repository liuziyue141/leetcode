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
    public void flatten(TreeNode root) {
        flatten2(root);
        
    }
    public TreeNode flatten2(TreeNode root){
        if(root == null){
            return null;
        }
        // TreeNode right;
        // TreeNode left;
        // System.out.println(root.val);
        TreeNode rightChild = root.right;
        TreeNode leftChild = root.left;
        root.left = null;
        root.right = null;
        TreeNode left = flatten2(leftChild);
        TreeNode right = flatten2(rightChild);
        if(left == null && right == null){
            return root;
        }
        else if(left == null){
            root.right = rightChild;
            return right;
        }else if(right == null){
            root.right = leftChild;
            return left;
        }else{
            root.right = leftChild;
            left.right = rightChild;
            return right;
        }

        
    }
}