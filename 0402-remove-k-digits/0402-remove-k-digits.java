class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Stack<Character> st = new Stack<>();
        for (int index = 0; index < num.length(); ++index) {
            char ch = num.charAt(index);
            while (!st.isEmpty() && k > 0 && (st.peek() - '0' > ch - '0')) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder resultBuilder = new StringBuilder();
        while (!st.isEmpty()) {
            resultBuilder.append(st.pop());
        }

        resultBuilder.reverse();

        while (!resultBuilder.isEmpty() && resultBuilder.charAt(0) - '0' == 0) {
            resultBuilder.deleteCharAt(0);
        }

        return resultBuilder.isEmpty() ? "0" : resultBuilder.toString();
    }
}