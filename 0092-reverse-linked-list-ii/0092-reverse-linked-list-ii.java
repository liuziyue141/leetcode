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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode leftPtr = dummy;
        ListNode rightPtr = head;
        for(int i = 1; i < left; i++){
            leftPtr = rightPtr;
            rightPtr = rightPtr.next;
        }
        ListNode leftBound = leftPtr;
        ListNode rightMost = rightPtr;
        for(int i = left; i <= right; i++){
            ListNode temp = rightPtr.next;
            rightPtr.next = leftPtr;
            leftPtr = rightPtr;
            rightPtr = temp;
        }
        leftBound.next = leftPtr;
        rightMost.next = rightPtr;

        return dummy.next;
    }
}