class Solution {
    private int lowerBound(int[] nums, int target) {
        int N = nums.length;
        int low = 0, high = N-1, mid;
        while (low <= high) {
            mid = low + (high - low)/2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);

        int[] result = new int[n];
        for (int index = 0; index < n; ++index) {
            int minPotion = (int) Math.ceil((success*1.0)/spells[index]);
            int indexPostion = lowerBound(potions, minPotion);
            result[index] = indexPostion == m ? 0 : m - indexPostion;
        }
        return result;
    }
}