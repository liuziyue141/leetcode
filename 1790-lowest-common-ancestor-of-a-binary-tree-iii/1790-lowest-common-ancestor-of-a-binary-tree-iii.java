/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(search(p, q)){
            return p;
        }
        Node parent = p.parent;
        Node cur = p;
        while(parent != q){
            if(parent.left != cur && search(parent.left, q)){
                return parent;
            }else if(parent.right != cur && search(parent.right, q)){
                return parent;
            }

            cur = parent;
            parent = cur.parent;
        }
        return parent;
    }

    public boolean search(Node root, Node q){
        if(root == null){
            return false;
        }
        if(root == q){
            return true;
        }
        return search(root.left, q) || search(root.right, q);
    }
}