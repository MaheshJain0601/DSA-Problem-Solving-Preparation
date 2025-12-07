class Solution {
    public int maxArea(int[] height) {
        int N = height.length;
        int maxWater = Integer.MIN_VALUE;
        int left = 0, right = N - 1;

        int currWidth, currHeight;

        while (left < right) {
            currWidth = right - left;
            currHeight = Math.min(height[left], height[right]);

            maxWater = Math.max(maxWater, currWidth*currHeight);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}