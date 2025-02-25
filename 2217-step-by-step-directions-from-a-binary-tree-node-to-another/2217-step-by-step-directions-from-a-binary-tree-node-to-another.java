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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // L P R
        // R P L
        StringBuilder startSt = new StringBuilder();
        findPath(root, startValue, startSt);
        StringBuilder destSt = new StringBuilder();
        findPath(root, destValue, destSt);

        int i = 0;
        while(i < destSt.length() && i < startSt.length() && destSt.charAt(i) == startSt.charAt(i)){
            i++;
        }
        StringBuilder resSt = new StringBuilder();
        for(int j = i; j < startSt.length(); j++){
            resSt.append('U');
        }

        for(int j = i; j < destSt.length(); j++){
            resSt.append(destSt.charAt(j));
        }

        return resSt.toString();
    }

    public boolean findPath(TreeNode root, int t, StringBuilder st){
        if (root == null){
            return false;
        }
        if(root.val == t){
            return true;
        }

        st.append('L');
        if (findPath(root.left, t, st)){
            return true;
        }
        st.deleteCharAt(st.length()-1);
        st.append('R');
        
        if (findPath(root.right, t, st)){
            return true;
        }
        st.deleteCharAt(st.length()-1);
        return false;
    }
}