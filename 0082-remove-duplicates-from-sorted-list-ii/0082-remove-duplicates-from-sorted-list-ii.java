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
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy.next;
        while(r!=null){
            if(r.next == null || l.next.val != r.next.val){
                l = l.next;
                r = r.next;
                continue;
            }
            while(r.next != null && l.next.val == r.next.val){
                r = r.next;
            }
            l.next = r.next;
            r = l.next;
        }
        return dummy.next;
    }
}