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
        LinkedList<String> list = new LinkedList<>(Arrays.asList(valSeq));
        return deserialize(list);
    }

    public TreeNode deserialize(LinkedList<String> val){
        String cur = val.removeFirst();
        if("*".equals(cur)){
            return null;
        }
        TreeNode curNode = new TreeNode(Integer.parseInt(cur));
        curNode.left = deserialize(val);
        curNode.right = deserialize(val);
        return curNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));