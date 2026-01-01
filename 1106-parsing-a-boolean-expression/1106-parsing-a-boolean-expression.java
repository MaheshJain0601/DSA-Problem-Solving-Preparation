class Solution {
    private char evaluateExpression(List<Character> temp, char op) {
        if (op == '!') {
            return temp.get(0) == 't' ? 'f' : 't';
        }

        if (op == '&') {
            for (int i = 0; i < temp.size(); ++i) {
                if (temp.get(i) == 'f') {
                    return 'f';
                }
            }
            return 't';
        }

        if (op == '|') {
            for (int i = 0; i < temp.size(); ++i) {
                if (temp.get(i) == 't') {
                    return 't';
                }
            }
            return 'f';
        }

        return 't'; // Code will never reach here
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        int index = 0, N = expression.length();
        char ch, op;
        List<Character> temp;
        while (index < N) {
            ch = expression.charAt(index);
            if (ch == ',') {
                index++;
                continue;
            } else if (ch == ')') {
                temp = new ArrayList<>();
                while (!st.isEmpty() && st.peek() != '(') {
                    temp.add(st.pop());
                }
                st.pop();
                op = st.pop();
                st.push(evaluateExpression(temp, op));
            } else {
                st.push(ch);
            }
            index++;
        }
        return st.pop() == 't'? true : false;
    }
}