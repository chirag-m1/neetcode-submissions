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
    ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    ListNode findKthNode(ListNode head, int k) {
        ListNode curr = head;
        while(k > 1 ) {
            k--;
            curr = curr.next;
            if(curr == null) return null;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode nextStart = null;
        ListNode lastEnd = null;
        while(start != null) {
            ListNode kthNode = findKthNode(start, k);
            // System.out.println(start.val + " " + kthNode.val);
            if(kthNode == null) {
                break;
            }
            else {
                nextStart = kthNode.next;
                kthNode.next = null;
                ListNode newHead = reverse(start);
                // System.out.println(newHead.val);
                if(start == head) {
                    head = newHead;
                    lastEnd = start;
                    lastEnd.next = nextStart;
                    start = nextStart;
                }
                else {
                    lastEnd.next = newHead;
                    start.next = nextStart;
                    lastEnd = start;
                    start = nextStart;
                }
            }
        }
        return head;
    }
}
