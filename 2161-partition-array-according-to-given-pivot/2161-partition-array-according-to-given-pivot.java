class Solution {
    // Approach-1: Brute
    // TC: O(2N)
    // SC: O(2N)
    public int[] pivotArrayApproach1(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        List<Integer> equalPivot = new ArrayList<>();

        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] < pivot) {
                lessThanPivot.add(nums[index]);
            } else if (nums[index] > pivot) {
                greaterThanPivot.add(nums[index]);
            } else {
                equalPivot.add(nums[index]);
            }
        }
        int[] result = new int[lessThanPivot.size() + greaterThanPivot.size() + equalPivot.size()];
        int index = 0;
        int resultIndex = 0;
        while (index < lessThanPivot.size()) {
            result[resultIndex] = lessThanPivot.get(index);
            resultIndex++;
            index++;
        }
        
        index = 0;
        while (index < equalPivot.size()) {
            result[resultIndex] = equalPivot.get(index);
            resultIndex++;
            index++;
        }
        
        index = 0;
        while (index < greaterThanPivot.size()) {
            result[resultIndex] = greaterThanPivot.get(index);
            resultIndex++;
            index++;
        }

        return result;
    }

    // Approach-2: Optimal
    // TC: O(2N)
    // SC: O(N)
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];

        int countLessThanPivot = 0;
        int countEqualPivot = 0;
        int countGreaterThanPivot = 0;

        for (int index = 0; index < nums.length; ++index) {
            if (nums[index] < pivot) {
                countLessThanPivot++;
            } else if (nums[index] > pivot) {
                countGreaterThanPivot++;
            } else {
                countEqualPivot++;
            }
        }


        int lessThanPivotIndex = 0;
        int equalPivotIndex = countLessThanPivot;
        int greaterThanPivotIndex = countLessThanPivot + countEqualPivot;
        int index = 0;

        while (index < nums.length) {
            if (nums[index] < pivot) {
                result[lessThanPivotIndex] = nums[index];
                lessThanPivotIndex++;
            } else if (nums[index] > pivot) {
                result[greaterThanPivotIndex] = nums[index];
                greaterThanPivotIndex++;
            } else {
                result[equalPivotIndex] = nums[index];
                equalPivotIndex++;
            }
            index++;
        }
        return result;
    }
}