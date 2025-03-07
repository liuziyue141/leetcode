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
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd){
        int curIdx = -1;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[idx]){
                curIdx = i;
                break;
            }
        }
        if(curIdx == -1){
            return null;
        }
        TreeNode cur = new TreeNode(preorder[idx]);
        idx++;
        cur.left = buildTree(preorder, inorder, inStart, curIdx-1);
        cur.right = buildTree(preorder, inorder, curIdx+1, inEnd);
        return cur; 
    }
}