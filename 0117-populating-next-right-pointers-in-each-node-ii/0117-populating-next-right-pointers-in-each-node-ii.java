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
        if(root == null || (root.left == null && root.right == null)){return root;}
        Node cur = root;

        while(cur!=null){
            Node target = null;
            Node dummy = new Node();
            Node nxt = dummy;

            while(cur!=null&&target==null){
                if(cur.left != null){
                    nxt.next = cur.left;
                    nxt = nxt.next;
                }
                if(cur.right != null){
                    nxt.next = cur.right;
                    nxt = nxt.next;
                }
                cur = cur.next;
            }
            if(cur == null){
                cur = dummy.next;
            }
        }

        return root;
    }

    // bfs
    // public Node connect(Node root) {
    //     if(root == null){return root;}
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         Node cur = q.poll();
    //         for(int i = 0; i < size - 1; i++){
    //             Node next = q.poll();
    //             cur.next = next;
    //             if(cur.left!=null){
    //                 q.add(cur.left);
    //             }
    //             if(cur.right!=null){
    //                 q.add(cur.right);
    //             } 
    //             cur = next;
    //         }
    //         if(cur.left!=null){
    //             q.add(cur.left);
    //         }
    //         if(cur.right!=null){
    //             q.add(cur.right);
    //         } 
    //     }
    //     return root;
    // }

    // recursion

    // public void connectHelper(Node root){
    //     if(root == null){
    //         return;
    //     }
    //     Node rightNode = root.right;
    //     Node leftNode = root.left;
    //     if(rightNode != null || leftNode != null){
    //         if(rightNode != null && leftNode != null){
    //             leftNode.next = rightNode;
    //         }

    //         Node cur = root.next;
    //         Node target = null;
    //         while(cur != null && target == null){
    //             if(cur.left != null){
    //                 target = cur.left;
    //             }else if(cur.right != null){
    //                 target = cur.right;
    //             }
    //             cur = cur.next;
    //         }

    //         if(rightNode != null){
    //             rightNode.next = target;
    //         }else{
    //             leftNode.next = target;
    //         }
    //     }
    //     connectHelper(rightNode);
    //     connectHelper(leftNode);
        
    // }
}