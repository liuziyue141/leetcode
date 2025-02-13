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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        head = sortList(head);
        next = sortList(next);

        return merge(head, next);
         
    }

    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(a!=null && b!=null){
            if(a.val > b.val){
                cur.next = b;
                b = b.next;
            }else{
                cur.next = a;
                a = a.next;
            }
            cur = cur.next;

        }
        if(a == null){
            cur.next = b;
        }else{
            cur.next = a;
        }

        return dummy.next;
    }
}