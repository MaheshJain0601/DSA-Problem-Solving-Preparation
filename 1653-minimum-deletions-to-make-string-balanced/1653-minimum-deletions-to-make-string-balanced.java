class Solution {
    // Approach-1 (One-pass better solution)
    // TC: O(N)
    // SC: O(N)
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        char ch;
        int count = 0;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                st.pop();
                count++;
            } else {
                st.push(ch);
            }
        }
        return count;
    }
}