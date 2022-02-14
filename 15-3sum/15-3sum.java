class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> answer = new HashSet<>();
        
        for (int index = 0; index < nums.length-2; ++index) {
            int begin = index + 1;
            int end = nums.length - 1;
            while (begin < end) {
                if (nums[index] + nums[begin] + nums[end] == 0) {
                    answer.add(Arrays.asList(nums[index], nums[begin], nums[end]));
                    begin++;
                    end--;
                } else if (nums[index] + nums[begin] + nums[end] > 0) {
                    end--;
                } else if (nums[index] + nums[begin] + nums[end] < 0) {
                    begin++;
                }
            }
        }
        return new ArrayList<>(answer);
    }
}