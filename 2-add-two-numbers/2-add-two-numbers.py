# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        ans = ListNode(0)
        temp1 = l1
        temp2 = l2
        carry = 0
        tail = ans
        while temp1 != None or temp2 != None or carry == 1:
            sum = carry
            if temp1 != None:
                sum += temp1.val
            
            if temp2 != None:
                sum += temp2.val
                            
            base = sum % 10
            carry = sum // 10
            tail.next = ListNode(base)
            tail = tail.next
            if temp1 != None:
                temp1 = temp1.next
            if temp2 != None:
                temp2 = temp2.next
        
        return ans.next