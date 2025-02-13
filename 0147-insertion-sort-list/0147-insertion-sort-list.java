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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head.next;
        head.next = null;
        if(cur == null){
            return head;
        }
        ListNode next = cur.next;
        cur.next = null;
        while(cur != null){
            ListNode pre = dummy;
            ListNode start = dummy.next;
            while(start!=null && cur.val > start.val){
                pre = start;
                start = start.next;
            }

            cur.next = start;
            pre.next = cur;

            cur = next;
            if(next != null){
                next = next.next;
                cur.next = null;
            }
        }
        return dummy.next;
    }
}