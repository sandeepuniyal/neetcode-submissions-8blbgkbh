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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //System.out.println(sum);
        
        ListNode l3 = null, temp = null;
        ListNode h1 = l1, h2 = l2;
        int c = 0, q=0;
        while(h1 != null && h2 != null){
            int sum = h1.val + h2.val + c;
            c = sum / 10;
            q = sum % 10;
            ListNode node = new ListNode(q, null);
            if(temp != null){
                temp.next = node;
                temp = node;
            }else{
                l3 = node;
                temp = node;
            }
            h1 = h1.next;
            h2 = h2.next;

        }
        while(h2 != null){
            int sum = h2.val + c;
            c = sum / 10;
            q = sum % 10;
            ListNode node = new ListNode(q, null);
            if(temp != null){
                temp.next = node;
                temp = node;
            }else{
                l3 = node;
                temp = node;
            }
            h2 = h2.next;
        }
        while(h1 != null){
            int sum = h1.val + c;
            c = sum / 10;
            q = sum % 10;
            ListNode node = new ListNode(q, null);
            if(temp != null){
                temp.next = node;
                temp = node;
            }else{
                l3 = node;
                temp = node;
            }
            h1 = h1.next;
        }
        if(c > 0){
            ListNode node = new ListNode(c, null);
            if(temp != null){
                temp.next = node;
                temp = node;
            }else{
                l3 = node;
                temp = node;
            }
        }
        return l3;
    }

}
