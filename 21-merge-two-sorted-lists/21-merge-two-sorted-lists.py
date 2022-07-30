# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        temp1 = list1
        temp2 = list2
        ans = ListNode(0)
        tail = ans
        while temp1 != None and temp2 != None:
            if temp1.val <= temp2.val:
                tail.next = temp1
                tail = temp1
                temp1 = temp1.next
            else:
                tail.next = temp2
                tail = temp2
                temp2 = temp2.next
        
        if temp1 != None:
            tail.next = temp1
        if temp2 != None:
            tail.next = temp2
        
        return ans.next
        
        