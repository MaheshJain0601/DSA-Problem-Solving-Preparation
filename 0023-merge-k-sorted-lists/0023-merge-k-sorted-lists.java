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
    private ListNode mergeTwoNodesRecursive(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        
        if (node1.val <= node2.val) {
            node1.next = mergeTwoNodesRecursive(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeTwoNodesRecursive(node1, node2.next);
            return node2;
        }
    }
    
    private ListNode mergeTwoNodesIterative(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
                current = current.next;
            } else {
                current.next = node2;
                node2 = node2.next;
                current = current.next;
            }
        }
        
        if (node1 == null) {
            current.next = node2; 
        } else {
            current.next = node1;
        }
        
        return dummy.next;
    }
    
    private ListNode divideMergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        
        if (start == end) {
            return lists[start];
        }
        
        int mid = start + (end - start)/2;
        ListNode left = divideMergeKLists(lists, start, mid);
        ListNode right = divideMergeKLists(lists, mid+1, end);
        
        return mergeTwoNodesIterative(left, right);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 1) {
            return (lists.length != 0) ? lists[0]: null;
        }
        
        int start = 0, end = lists.length - 1;
        
        return divideMergeKLists(lists, start, end);
    }
}