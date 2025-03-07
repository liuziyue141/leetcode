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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        int curIdx = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                curIdx = i - inStart;
                break;
            }
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        cur.left = buildTree(preorder, inorder, preStart + 1, preStart + curIdx, inStart, inStart + curIdx - 1);
        cur.right = buildTree(preorder, inorder, preStart + curIdx + 1, preEnd, inStart + curIdx + 1, inEnd);
        return cur; 
    }
}