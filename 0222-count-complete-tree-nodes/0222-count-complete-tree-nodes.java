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
    public int countNodes(TreeNode root) {
        int depth = findDepth(root);
        if(depth == 1 || depth == 0){
            return depth;
        }
        return findBreak(root, depth) + (int)Math.pow(2, depth-1) -1;
    }

    public int findDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findDepth(root.left) + 1;
    }

    public int findBreak(TreeNode root, int depth){
        if(root == null){
            return 1;
        }

        int lCnt = 1;
        TreeNode l = root.left;
        while(l != null){
            l = l.right;
            lCnt++;
        }

        int rCnt = 1;
        TreeNode r = root.right;
        while(r!=null){
            r = r.left;
            rCnt++;
        }
        int res = 0;
        int half = (int)(Math.pow(2, depth - 2));
        if(rCnt == lCnt && lCnt < depth){
            res = findBreak(root.left, depth-1);
            return res;
        }else if (rCnt == lCnt && lCnt == depth){
            res = findBreak(root.right, depth-1);
            return half + res;
        }else{
            return half;
        }        
    }
}