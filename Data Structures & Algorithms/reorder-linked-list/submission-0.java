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
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    ListNode findMiddle(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode midHead = mid.next;
        mid.next = null;
        midHead = reverse(midHead);
        while(head != null && midHead != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = midHead.next;
            head.next = midHead;
            midHead.next = temp1;
            head = temp1;
            midHead = temp2;
        }
    }
}
