/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append('*');
            return;
        }
        sb.append(root.val);
        sb.append(' ');
        serialize(root.left, sb);
        sb.append(' ');
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] valSeq = data.split(" ");
        return deserialize(valSeq, new int[]{0});
    }

    public TreeNode deserialize(String[] val, int[] idx){
        if("*".equals(val[idx[0]])){
            idx[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(val[idx[0]]));
        idx[0]++;
        cur.left = deserialize(val, idx);
        cur.right = deserialize(val, idx);
        return cur;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));