class Solution {
    private void findSubsequencesHelper(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {
        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }

        Set<Integer> lookup = new HashSet<>();

        for (int i = index; i < nums.length; ++i) {
            if ((temp.isEmpty() || temp.get(temp.size() - 1) <= nums[i]) & !lookup.contains(nums[i])) {
                temp.add(nums[i]);
                findSubsequencesHelper(nums, result, temp, i + 1);
                temp.remove(temp.size() - 1);
                lookup.add(nums[i]);
            }
        }

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 1) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        findSubsequencesHelper(nums, result, temp, 0);
        return result;
    }
}