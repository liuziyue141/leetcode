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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null){
            size++;
            cur = cur.next;
        }
        ListNode tail = cur;
        k = k%size;
        if(k == 0){
            return head;
        }
        cur = dummy;
        for(int i = size; i > k; i--){
            cur = cur.next;
        }
        dummy.next = cur.next;
        tail.next = head;
        cur.next = null;

        return dummy.next;
    }
}