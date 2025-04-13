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
        int size = 1;
        ListNode tail = head;
        while(tail.next != null){
            size++;
            tail = tail.next;
        }
        k = k%size;
        if(k == 0){
            return head;
        }
        ListNode cur = head;
        for(int i = 0; i < size - k - 1; i++){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        tail.next = head;
        cur.next = null;
        return newHead;
    }
}