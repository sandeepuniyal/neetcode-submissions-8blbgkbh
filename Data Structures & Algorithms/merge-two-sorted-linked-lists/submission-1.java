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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = null;
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode l3 = list3;

        ListNode n;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                n = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                n = new ListNode(l2.val);;
                l2 = l2.next;
            }
            if(list3 == null){
                list3 = n;
                l3 = n;
            }else{
                l3.next = n;
                l3 = n;
            }
        }
        
        while(l1 != null){
            n = new ListNode(l1.val);
            l1 = l1.next;

            if(list3 == null){
                list3 = n;
                l3 = n;
            }else{
                l3.next = n;
                l3 = n;
            }
            
        }
    
        while(l2 != null){
            n = new ListNode(l2.val);
            l2 = l2.next;

            if(list3 == null){
                list3 = n;
                l3 = n;
            }else{
                l3.next = n;
                l3 = n;
            }
        }
        return list3;
    }
}