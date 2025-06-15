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

class Element {
    TreeNode node;
    int idx;
    public Element(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Element> queue = new ArrayList<>();
        List<Element> res = new ArrayList<>();
        queue.add(new Element(root, 0));

        while(!queue.isEmpty()){
            Element cur = queue.removeFirst();
            res.add(cur);
            if(cur.node.left != null){
                queue.add(new Element(cur.node.left, cur.idx - 1));
            }
            if(cur.node.right != null){
                queue.add(new Element(cur.node.right, cur.idx + 1));
            }
        }

        Collections.sort(res, (Element a, Element b) -> a.idx - b.idx);
        List<List<Integer>> result = new ArrayList<>();
        int slow = 0;
        int fast = 0;
        while(fast < res.size()){
            List<Integer> cur = new ArrayList<>();
            while(fast < res.size() && res.get(slow).idx == res.get(fast).idx){
                cur.add(res.get(fast).node.val);
                fast++;
            }
            result.add(cur);
            slow = fast;
        }

        return result;
    }
}