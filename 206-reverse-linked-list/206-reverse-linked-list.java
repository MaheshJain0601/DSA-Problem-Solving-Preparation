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
    public ListNode reverseList(ListNode head) {
       // T.C: O(N)
       // S.C: O(1)
       ListNode prev = null;
        ListNode current = head;
        ListNode later;
        while (current != null) {
            later = current.next;
            current.next = prev;
            prev = current;
            current = later;
        }
        return prev;
    }
    public ListNode reverseListReverse(ListNode head) {
        // T.C: O(N)
        // S.C: O(N)
        // base case
        if(head == null || head.next == null) return head;
        
        ListNode newHead = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;

        return newHead;
    }
    
}