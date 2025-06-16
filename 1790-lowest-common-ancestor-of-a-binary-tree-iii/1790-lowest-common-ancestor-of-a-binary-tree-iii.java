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
        Node p_copy = p;
        Node q_copy = q;

        while(p_copy != q_copy){
            p_copy = p_copy==null?q:p_copy.parent;
            q_copy = q_copy==null?p:q_copy.parent;
        }
        return p_copy;
    }
}