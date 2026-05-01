/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();

        Node c1 = head;
        Node c2 = null;
        Node newHead = null;

        while(c1 != null){
            Node node = new Node(c1.val);
            if(newHead == null){
                newHead = node;
                c2 = newHead;
            }else{
                c2.next = node;
                c2 = c2.next;
            }
            map.put(c1, c2);
            c1 = c1.next;
        }

        c1 = head;
        c2 = newHead;
        while(c1 != null){
            c2.random = map.get(c1.random);
            c1 = c1.next;
            c2 = c2.next;
        }

        return newHead;
    }
}
