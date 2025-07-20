class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for (int index = 2 * n - 1; index >= 0; --index) {
            while (!st.isEmpty() && st.peek() <= nums[index % n]) {
                st.pop();
            }

            if (index < n) {
                result[index] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[index % n]);
        }
        return result;
    }
}