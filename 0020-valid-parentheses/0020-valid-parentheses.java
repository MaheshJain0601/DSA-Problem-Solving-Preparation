class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.empty() || !map.containsKey(ch) || map.get(ch) != st.peek()) {
                    return false;
                }
                st.pop();
            }
        }
        return st.empty();
    }
}