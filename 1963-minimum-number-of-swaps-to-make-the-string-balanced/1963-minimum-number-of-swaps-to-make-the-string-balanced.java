class Solution {
    // Approach-1 (With space)
    // TC: O(N)
    // SC: O(N)
    public int minSwapsStack(String s) {
        Stack<Character> st = new Stack<>();
        char ch;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (ch == '[') st.push(ch);
            else if (!st.isEmpty()) st.pop();
        }
        return (st.size() + 1)/2;
    }

    // Approach-2 (Without space)
    // TC: O(N)
    // SC: O(1)
    public int minSwaps(String s) {
        int size = 0;
        char ch;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (ch == '[') size++;
            else if (size > 0) size--;
        }
        return (size + 1)/2;
    }
}