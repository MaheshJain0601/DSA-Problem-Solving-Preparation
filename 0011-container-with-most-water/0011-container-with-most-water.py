class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        maxArea = 0
        
        while (left <= right):
            width = right - left
            length = min(height[left], height[right])
            maxArea = max(maxArea, width * length)
            if height[left] <= height[right]:
                left = left + 1
            else:
                right = right - 1
        
        return maxArea
            
        