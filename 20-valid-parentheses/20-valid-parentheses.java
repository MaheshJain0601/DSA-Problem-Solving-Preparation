import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int N = s.length();
        if (N % 2 != 0) {
            return false;
        }
        
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '(') {
                st.push(')');
            }
            else if (s.charAt(i) == '{') {
                st.push('}');
            }
            else if(s.charAt(i) == '[') {
                st.push(']');
            }
            else if (st.isEmpty() || st.pop() != s.charAt(i)) {
                return false;                
            }
        }
        return st.isEmpty();
    }
}