class Solution {
    // Approach - 1: Brute force
    // TC: O(N^2)
    // SC: O(N)
    public String reverseParenthesesApproach1(String s) {
        Stack<Integer> openBracket = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (ch == '(') {
                openBracket.push(sb.length());
            } else if (ch == ')') {
                int startIndex = openBracket.pop();
                reverse(sb, startIndex, sb.length() - 1);
            } else {
                sb.append(ch);
            }
            index++;
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // Approach-2 (Optimal)
    // TC: O(N)
    // SC: O(N)
    public String reverseParentheses(String s) {
        Stack<Integer> openBracketIndex = new Stack<>();
        Map<Integer, Integer> bracketMapping = new HashMap<>();
        char ch;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            if (ch == '(') {
                openBracketIndex.push(index);
            } else if (ch == ')') {
                int leftBracketIndex = openBracketIndex.pop();
                bracketMapping.put(leftBracketIndex, index);
                bracketMapping.put(index, leftBracketIndex);
            }
        }


        StringBuilder sb = new StringBuilder();

        int index = 0, flag = 1;
        while (index < s.length()) {
            ch = s.charAt(index);
            if (ch == '(' || ch == ')') {
                index = bracketMapping.get(index);
                flag = -flag;
            } else {
                sb.append(ch);
            }
            index += flag;
        }
        return sb.toString();
    }
}