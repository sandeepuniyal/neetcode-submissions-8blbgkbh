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
    public void reorderList(ListNode head) {
        ListNode l1 = head;

        ListNode temp1 = l1;
        ListNode temp2 = l1;

        while(temp2 != null && temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        ListNode l2 = temp1.next;
        temp1.next = null;
        temp1 = l1; temp2 = l2;

        /*
        while(temp1 != null){
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.println();
        while(temp2 != null){
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
        */

        if(l2 == null){
            head =  l1;
            return;
        }

        ListNode l3 = l2;
        temp1 = l3;
        temp2 = l3.next;
        temp1.next = null;

        while(temp2 != null){
            l3 = temp2;
            temp2 = l3.next;
            l3.next = temp1;
            temp1 = l3;
        }
        /*
        temp2 = l3;
        System.out.println();
        while(temp2 != null){
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
        */

        temp1 = l1; 
        temp2 = l1.next; 
        ListNode temp3 = l3; 
        ListNode temp4 = l3.next;
        
        while(temp1 != null && temp3 != null ){
            temp1.next = temp3;
            temp3.next = temp2;

            temp1 = temp2;
            temp2 = (temp2 != null) ? temp2.next : temp2;

            temp3 = temp4;
            temp4 = (temp4 != null) ? temp4.next : temp4;

        }

        head = l1;
        
    }
}
