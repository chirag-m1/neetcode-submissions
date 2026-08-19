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
        PriorityQueue<ListNode> pq = 
        new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode list : lists) {
            if(list != null) {            
                pq.offer(list); 
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = node;
            if(node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
