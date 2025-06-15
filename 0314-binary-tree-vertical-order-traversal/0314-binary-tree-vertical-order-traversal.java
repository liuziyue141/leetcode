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
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Element> queue = new ArrayList<>();
        queue.add(new Element(root, 0));
        while(!queue.isEmpty()){
            Element cur = queue.removeFirst();
            map.putIfAbsent(cur.idx, new ArrayList<>());
            map.get(cur.idx).add(cur.node.val);
            if (cur.node.left != null){
                queue.add(new Element(cur.node.left, cur.idx - 1));
            }
            if (cur.node.right != null){
                queue.add(new Element(cur.node.right, cur.idx + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sortedKey = new ArrayList<>(map.keySet());
        Collections.sort(sortedKey);
        for(int idx : sortedKey){
            result.add(map.get(idx));
        }
        return result;
    }
}