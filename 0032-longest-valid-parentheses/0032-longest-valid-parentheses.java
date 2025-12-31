class Solution {
    // TC: O(N)
    // SC: O(N)
    public int longestValidParenthesesApproach1(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses(String s) {
        int maxLength = 0;
        int openBrackets = 0, closeBracket = 0;
        // Left to Right pass
        for (int index = 0; index < s.length(); ++index) {
            if (s.charAt(index) == '(') {
                openBrackets++;
            } else {
                closeBracket++;
            }

            if (openBrackets == closeBracket) {
                maxLength = Math.max(maxLength, openBrackets * 2);
            } else if (closeBracket > openBrackets) {
                openBrackets = 0;
                closeBracket = 0;
            }
        }

        openBrackets = closeBracket = 0;

        for (int index = s.length() - 1; index >= 0; --index) {
            if (s.charAt(index) == '(') {
                openBrackets++;
            } else {
                closeBracket++;
            }

            if (openBrackets == closeBracket) {
                maxLength = Math.max(maxLength, openBrackets * 2);
            } else if (openBrackets > closeBracket) {
                openBrackets = 0;
                closeBracket = 0;
            }
        }

        return maxLength;
    }
}