class Solution {
    int MOD = (int) (1e9 + 7);
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
    private int[] findPreviousSmallerOrEqualElement(int[] arr) {
        int N = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[N];
        for (int index = 0; index < N; ++index) {
            // Monotonically decreasing stack
            while (!st.isEmpty() && arr[st.peek()] > arr[index]) {
                st.pop();
            }
            result[index] = st.isEmpty() ? -1 : st.peek();
            st.push(index);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int[] nse = findNextSmallerElement(arr);
        int[] psee = findPreviousSmallerOrEqualElement(arr);

        long result = 0;

        for (int index = 0; index < N; ++index) {
            int right = nse[index] - index;
            int left = index - psee[index];

            result = (result + (right * left * 1L * arr[index]) % (MOD)) % (MOD);
        }

        return (int) result;
    }
}