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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // T.C: O(N+M)
        // S.C: O(1)
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            tail.next = list2;
        } 
        if (list2 == null) {
            tail.next = list1;
        }
        return ans.next;
    }
    
    public ListNode recurMergeTwoLists(ListNode list1, ListNode list2) {
        // T.C: O(N+M)
        //S.C: O(N+M)
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = recurMergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = recurMergeTwoLists(list1, list2.next);
            return list2;
        }
    }
    
}