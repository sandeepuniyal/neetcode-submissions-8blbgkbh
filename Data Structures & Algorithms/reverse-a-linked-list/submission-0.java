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
    ListNode reverseHead = null;
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode n = reverse(null, head);
        return reverseHead;
    }

    private ListNode reverse(ListNode prev, ListNode head){
        if(head == null){
            return head;
        }
        ListNode node =  reverse(prev == null? head : prev.next, head.next);
        if(node == null){
            reverseHead = head;
        }

        head.next = prev;
        return head;
    }
}
