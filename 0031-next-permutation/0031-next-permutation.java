class Solution {
    private void swap(int[] nums, int fromIndex, int toIndex) {
        if (nums == null || nums.length <= 1 || fromIndex < 0 || fromIndex >= nums.length || toIndex < 0 || toIndex >= nums.length) {
            return;
        }
        int temp;
        temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }

     private void reverse(int[] nums, int startIndex, int endIndex) {
        if (nums == null || nums.length <= 1 || startIndex >= endIndex) {
            return;
        }
        
        int temp;
        int i = startIndex, j = endIndex;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int N = nums.length;
        int breakPointIndex = -1;
        for (int index = N - 2; index >= 0; index--) {
            if (nums[index] < nums[index + 1]) {
                breakPointIndex = index;
                break;
            }
        }
        // nums provided is last permutation
        if (breakPointIndex == -1) {
            reverse(nums, 0, N - 1);
            return;
        }

        for (int index = N - 1; index > breakPointIndex; --index) {
            if (nums[index] > nums[breakPointIndex]) {
                swap(nums, index, breakPointIndex);
                break;
            }
        }

        reverse(nums, breakPointIndex + 1, N - 1);
    }
}