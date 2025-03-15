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
    int pEnd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pEnd = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd){
        if(iStart > iEnd || pEnd < 0){
            return null;
        }

        TreeNode cur = new TreeNode(postorder[pEnd]);
        int idx = -1;
        for(int i = iStart; i <= iEnd; i++){
            if(postorder[pEnd] == inorder[i]){
                idx = i;
            }
        }
        pEnd--;
        cur.right = buildTree(inorder, postorder, idx + 1, iEnd);
        cur.left = buildTree(inorder, postorder, iStart, idx-1);
        return cur;
    }
}