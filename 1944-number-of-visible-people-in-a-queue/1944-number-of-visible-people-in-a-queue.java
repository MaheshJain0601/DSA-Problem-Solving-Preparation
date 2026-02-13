class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int visible = 0, height;

        int[] result = new int[heights.length];

        for (int index = heights.length - 1; index >= 0; --index) {
            height = heights[index];
            visible = 0;
            while (!st.isEmpty() && height > st.peek()) {
                st.pop();
                visible++;
            }
            if (!st.isEmpty()) {
                visible++;
            }
            result[index] = visible;
            st.push(height);
        }
        return result;
    }
}