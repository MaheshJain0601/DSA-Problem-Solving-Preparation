class Solution {
    public String removeDuplicateLetters(String s) {
        int[] frequency = new int[26];
        boolean[] used = new boolean[26];
        char ch;
        
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            frequency[ch - 'a'] += 1;
        }

        Deque<Character> st = new ArrayDeque<>();
        
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            frequency[ch - 'a'] -= 1;

            if (used[ch - 'a']) continue;

            while (!st.isEmpty() && st.peek() > ch && frequency[st.peek() - 'a'] > 0) {
                used[st.pop() - 'a'] = false;
            }

            st.push(ch);
            used[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.removeLast());
        }
        return result.toString();
    }
}