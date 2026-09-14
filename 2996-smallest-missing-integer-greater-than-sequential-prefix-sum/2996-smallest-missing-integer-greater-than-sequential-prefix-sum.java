class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> uniqueElemnts = new HashSet<>();
        for (int num: nums) {
            uniqueElemnts.add(num);
        }

        int seqSum = nums[0];

        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[j-1] + 1) {
                break;
            } 
            seqSum += nums[j];
        }

        while (uniqueElemnts.contains(seqSum)) {
            seqSum++;
        }
        return seqSum;
    }
}