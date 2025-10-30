/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> {
            return a.val - b.val;
        });

        for(int i = 0; i < lists.length; i++){
            if(lists[i]!=null)
            pq.offer(lists[i]);
        }

        
        while(!pq.isEmpty()){
            ListNode removed = pq.poll();
            cur.next = removed;
            cur = cur.next;
            if(removed.next != null){
                pq.offer(removed.next);
            }
        }
        return dummy.next;
    }
}