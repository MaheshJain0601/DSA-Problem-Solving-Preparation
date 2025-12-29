class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        int[] result = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int index = N - 1; index >= 0; --index) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? 0 : st.peek() - index;
            st.push(index);
        }
        return result;
    }
}