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
class BSTIterator {
    List<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new ArrayList<>();
        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        if(!hasNext()){
            return Integer.MIN_VALUE;
        }else{
            TreeNode node = st.remove(st.size() - 1);
            int val = node.val;
            if(node.right != null){
                node = node.right;
                while(node != null){
                    st.add(node);
                    node = node.left;
                }
            }
            return val;
        }
    }
    
    public boolean hasNext() {
        if(st.isEmpty()){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */