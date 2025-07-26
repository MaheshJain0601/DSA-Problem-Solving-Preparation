class Solution {
    
    private int[] findNextSmallerElement(int[] arr) {
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[N];
        for (int index = N - 1; index >= 0; --index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && arr[st.peek()] >= arr[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? N : st.peek();
            st.push(index);
        }
        return result;
    }

    private int[] findPreviousSmallerElement(int[] arr) {
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[N];
        for (int index = 0; index < N; ++index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && arr[st.peek()] >= arr[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? -1 : st.peek();
            st.push(index);
        }
        return result;
    }
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] nse = findNextSmallerElement(heights);
        int[] pse = findPreviousSmallerElement(heights);

        int maximumHeight = 0;

        for (int index = 0; index < N; ++index) {
            maximumHeight = Math.max(maximumHeight, heights[index] * (nse[index] - pse[index] - 1));
        }
        return maximumHeight;
    }
}