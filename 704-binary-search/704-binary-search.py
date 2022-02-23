class Solution:
    """
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
        return -1
    """
    def search(self, nums: List[int], target: int) -> int:
        return self.binaryHelper(nums, target, 0, len(nums)-1)
    
    def binaryHelper(self, nums, target, left, right):
        if left > right:
            return -1
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif target < nums[mid]:
            return self.binaryHelper(nums, target, left, mid - 1)
        elif target > nums[mid]:
            return self.binaryHelper(nums, target, mid+1, right)