class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int result = 0;
        char ch;
        
        // Left to Right Traversal
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (ch == '(') open += 1;
            else if (ch == ')') close += 1;
            
            if (open == close) {
                result = Math.max(result, open + close);
            } else if (close > open) {
                close = open = 0;
            } // Do nothing in-case of open > close, as we are moving forward
        }

        open = close = 0;

        // Right to Left Traversal
        for (int index = s.length() - 1; index >= 0; --index) {
            ch = s.charAt(index);
            if (ch == '(') open += 1;
            else if (ch == ')') close += 1;
            
            if (open == close) {
                result = Math.max(result, open + close);
            } else if (open > close) {
                close = open = 0;
            } // Do nothing in-case of close > open, as we are moving forward
        }
        return result;
    }
}