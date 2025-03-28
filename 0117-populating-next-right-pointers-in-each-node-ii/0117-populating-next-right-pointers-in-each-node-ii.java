/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        connectHelper(root);
        return root;
    }


    public void connectHelper(Node root){
        if(root == null){
            return;
        }
        Node rightNode = root.right;
        Node leftNode = root.left;
        if(rightNode != null || leftNode != null){
            if(rightNode != null && leftNode != null){
                leftNode.next = rightNode;
            }

            Node cur = root.next;
            Node target = null;
            while(cur != null && target == null){
                if(cur.left != null){
                    target = cur.left;
                }else if(cur.right != null){
                    target = cur.right;
                }
                cur = cur.next;
            }

            if(rightNode != null){
                rightNode.next = target;
            }else{
                leftNode.next = target;
            }
        }
        connectHelper(rightNode);
        connectHelper(leftNode);
        
    }
}