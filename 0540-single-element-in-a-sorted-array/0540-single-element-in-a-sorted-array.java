class Solution {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        
        if(N == 1) 
            return nums[0];
        
        if (nums[0] != nums[1]) 
            return nums[0];
        
        if (nums[N-1] != nums[N-2])
            return nums[N-1];
        
        int low = 1, high = N - 2;
        int mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            
            // Inorder to element be on right side duplicate pattern will be (even, odd)
            // Inorder to element be on left side duplicate pattern (odd, even)
            // Current index is odd or even, then check with duplicate element with pattern (even, odd)
            // i.e., single element exists on right half 
            if ((mid%2 == 1 && nums[mid-1] == nums[mid]) || (mid%2 == 0 && nums[mid] == nums[mid+1])) {
                low = mid + 1; // Eliminating the left side
            } else {
                high = mid - 1;
            }
        }
        
        // Not possible, as per problem statement
        return -1;    
    }
}