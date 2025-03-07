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
    public ListNode partition(ListNode head, int x) {
        ListNode lessThan = new ListNode();
        ListNode greaterThan = new ListNode();

        ListNode lessCur = lessThan;
        ListNode greatCur = greaterThan;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val < x){
                lessCur.next = cur;
                lessCur = cur;
            }else{
                greatCur.next = cur;
                greatCur = cur;
            }
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }

        lessCur.next = greaterThan.next;
        greaterThan.next = null;
        return lessThan.next;
    }
}