class Solution {
    private void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> tempList, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Take
        tempList.add(nums[index]);
        subsetsHelper(nums, result, tempList, index + 1);
        
        // Not take
        tempList.remove(tempList.size() - 1);
        subsetsHelper(nums, result, tempList, index + 1);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, result, new ArrayList<>(), 0);
        return result;
    }
}