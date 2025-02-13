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
        ListNode cur = head;
        while(cur != null){
            ListNode pre = dummy;
            while(pre.next!=null && cur.val > pre.next.val){
                pre = pre.next;
            }
            ListNode next = cur.next;

            cur.next = pre.next;
            pre.next = cur;

            cur = next;
        }
        return dummy.next;
    }
}