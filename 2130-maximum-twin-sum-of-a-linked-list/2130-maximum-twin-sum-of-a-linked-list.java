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

import java.lang.Math;
class Solution {
    
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseLinkedList(ListNode middle) {
        ListNode previous = null;
        
        ListNode current = middle;
        ListNode next;
        
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
    }
    
    public int getMaximumTwinSum(ListNode head,ListNode reversedMiddle) {
        int maxTwin = Integer.MIN_VALUE;
        
        while (head != null && reversedMiddle != null) {
            maxTwin = Math.max(maxTwin, head.val + reversedMiddle.val);
            
            head = head.next;
            reversedMiddle = reversedMiddle.next;
        }
        
        return maxTwin;
    }
    
    public int pairSum(ListNode head) {
        // Find mid node of the LinkedList
        ListNode middle = findMiddle(head);
        
        // Reversed the second half of the LinkedList from middle
        ListNode reversedMiddle = reverseLinkedList(middle);
        
        // Get max twin sum
        int maxTwin = getMaximumTwinSum(head, reversedMiddle);
        
        return maxTwin;
    }
}