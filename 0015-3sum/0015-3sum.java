class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int arrayLength = nums.length;
        if (nums.length < 3) {
            return answer;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < arrayLength; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = arrayLength - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    answer.add(temp);
                    j++;
                    k--;
                    while (j < arrayLength && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > 0 && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        
        
        return answer;
    }
}