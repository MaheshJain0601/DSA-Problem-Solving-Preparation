class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int N = asteroids.length;
        Stack<Integer> st = new Stack<>();

         for (int asteroid : asteroids) {
            boolean alive = true;
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (st.peek() < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                } else if (st.peek() == Math.abs(asteroid)) {
                    st.pop();
                }
                alive = false;
                break;
            }
            if (alive) {
                st.push(asteroid);
            }
        }
        int[] result = new int[st.size()];
        for (int index = st.size() - 1; index >= 0; index--) {
            result[index] = st.pop();
        }
        return result;
    }
}