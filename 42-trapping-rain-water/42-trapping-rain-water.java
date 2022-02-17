class Solution {
    public int trap(int[] height) {
        int N = height.length;
        if(N <= 2){
            return 0;
        }
        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = height[0];
        right[N-1] = height[N-1];
        for(int i = 1; i < N; i++){
            left[i] = Math.max(left[i-1], height[i]);
            right[N-i-1] = Math.max(right[N-i], height[N-i-1]);
        }
        
        int trapped = 0;
        for(int i = 0; i < N; i++){
            trapped += (Math.min(left[i], right[i]) - height[i]);
        }
        return trapped;
    }
}