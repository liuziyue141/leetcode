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
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int depth; // Additional field to track depth

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) {
            return null;
        }

        // Use a stack to keep track of nodes and their potential children
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        int i = 0; // Index to traverse the string

        while (i < traversal.length()) {
            // Count the number of dashes to determine depth
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Parse the number (node value) after the dashes
            int val = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Create a new node with the parsed value
            TreeNode node = new TreeNode(val);

            // If the stack is empty, this is the root
            if (stack.isEmpty()) {
                stack.push(node);
            } else {
                // Pop nodes from the stack until we find the parent (depth - 1)
                while (!stack.isEmpty() && stack.peek().depth >= depth) {
                    stack.pop();
                }

                // Attach the new node as a left or right child of the parent
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                stack.push(node);
            }
            // Store the depth of the current node in the TreeNode for tracking
            node.depth = depth;
        }

        // The root is the first node pushed onto the stack
        return stack.isEmpty() ? null : stack.get(0);
    }
}