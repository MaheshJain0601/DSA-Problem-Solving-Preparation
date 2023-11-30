class Solution {
    public int maxArea(int[] height) {
        
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        
        while (left < right) {
            int w = (right - left);
            int h = Math.min(height[left], height[right]);
            
            maxArea = Math.max(maxArea, h*w);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}