class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> tempList, int index) {
        result.add(new ArrayList<>(tempList));    

        for (int i = index; i < nums.length; ++i) {
            if (i != index && nums[i] == nums[i-1]) {
                continue; // Duplicate ignore
            }
            tempList.add(nums[i]);
            subsetsHelper(nums, result, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}