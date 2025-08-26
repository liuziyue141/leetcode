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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode nxt = head;
        while(nxt != null){
            if(cur.val == nxt.val){
                cur.next = nxt.next;
                nxt.next = null;
                nxt = cur.next; 
                continue;
            }
            cur = cur.next;
            nxt = nxt.next;
        }
        return dummy.next;
    }
}