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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length -1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd){
        if(iStart == iEnd){
            return new TreeNode(inorder[iStart]);
        }
        if(iStart > iEnd){
            return null;
        }

        TreeNode cur = new TreeNode(postorder[pEnd]);
        int idx = -1;
        for(int i = iStart; i <= iEnd; i++){
            if(postorder[pEnd] == inorder[i]){
                idx = i;
            }
        }
        int rightCnt = iEnd - idx;
        cur.left = buildTree(inorder, postorder, iStart, idx-1, pStart, pEnd - rightCnt - 1);
        cur.right = buildTree(inorder, postorder, idx + 1, iEnd, pEnd - rightCnt, pEnd - 1);
        return cur;
    }
}