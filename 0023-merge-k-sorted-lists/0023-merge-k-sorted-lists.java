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
        int finished = 0;
        for(int i = 0; i < lists.length; i++){
            if(lists[i]== null){
                finished++;
            }
        }
        while(finished != lists.length){
            int idx = -1;
            for(int i = 0; i < lists.length; i++){
                if(lists[i]!= null && (idx == -1 || lists[idx].val > lists[i].val)){
                    idx = i;
                }
            }
            
            if(idx != -1){
                cur.next = lists[idx];
                cur = cur.next;
                lists[idx] = lists[idx].next;
                if(lists[idx] == null){
                    finished++;
                }
            }
        }
        return dummy.next;
    }
}