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
        if(head == null) return null;
        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        Node newHead = temp.next;
        Node temp2 = newHead;
        while(temp != null && temp2 != null) {
            temp2 = temp.next;
            temp2.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
            // temp2 = temp2.next.next;
        }
        temp = head;
        temp2 = newHead;
        while(temp != null && temp2 != null) {
            temp.next = temp.next.next;
            if(temp2.next != null) {
                temp2.next = temp2.next.next;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return newHead;
    }
}
