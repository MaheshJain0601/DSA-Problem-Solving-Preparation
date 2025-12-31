class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int N = positions.length;
        Integer[] indices = new Integer[N];

        for (int index = 0; index < N; ++index) {
            indices[index] = index;
        }

        Arrays.sort(indices, (i, j) -> Integer.compare(positions[i], positions[j]));
        Stack<Integer> st = new Stack<>();

        for (int currentIndex: indices) {
            if (directions.charAt(currentIndex) == 'R') {
                st.push(currentIndex);
                continue;
            }

            while (!st.isEmpty() && healths[currentIndex] > 0) {
                int topIndex = st.peek();
                if (healths[topIndex] > healths[currentIndex]) {
                    healths[topIndex] -= 1;
                    healths[currentIndex] = 0;
                } else if (healths[topIndex] < healths[currentIndex]) {
                    st.pop();
                    healths[currentIndex] -= 1;
                    healths[topIndex] = 0;
                } else {
                    st.pop();
                    healths[currentIndex] = 0;
                    healths[topIndex] = 0;
                }
            }
        }


        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < N; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}