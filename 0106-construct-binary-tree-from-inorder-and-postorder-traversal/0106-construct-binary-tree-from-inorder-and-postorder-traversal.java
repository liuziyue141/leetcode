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
    HashMap<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pEnd = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            idxMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int iStart, int iEnd){
        if(iStart > iEnd || pEnd < 0){
            return null;
        }

        TreeNode cur = new TreeNode(postorder[pEnd]);
        int idx = idxMap.get(postorder[pEnd]);
        pEnd--;
        cur.right = buildTree(inorder, postorder, idx + 1, iEnd);
        cur.left = buildTree(inorder, postorder, iStart, idx-1);
        return cur;
    }
}