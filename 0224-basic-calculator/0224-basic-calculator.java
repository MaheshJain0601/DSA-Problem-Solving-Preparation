class Solution {
    public int calculate(String s) {
        int N = s.length();
        int index = 0, result = 0, number = 0;
        int sign = 1;
        char ch;
        Stack<Integer> st = new Stack();
        while (index < N) {
            ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                number = number*10 + (ch - '0');
            } else if (ch == '+') {
                result += (number * sign);
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += (number * sign);
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (ch == ')') {
                result += (number*sign);
                number = 0;
                sign = st.pop();
                result *= sign;
                result += st.pop();
                sign = 1;
            }
            index++;
        }
        result += (number * sign);
        return result;
    }
}