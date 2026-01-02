class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int operations = 0, index = 0;

        while (index < nums.length) {
            while (!st.isEmpty() && nums[index] < st.peek()) {
                st.pop();
            }

            if (nums[index] == 0) {
                index++;
                continue;
            }
            if (st.isEmpty() || st.peek() < nums[index]) {
                st.push(nums[index]);
                operations++;
            }
            index++;
        }
        return operations;
    }
}