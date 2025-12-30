class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for (String token: tokens) {
            if (operators.contains(token)) {
                Long operand1 = (long) operands.pop();
                Long operand2 = (long) operands.pop();
                if ("+".equals(token)) {
                    operands.push((int)(operand1 + operand2));
                } else if ("-".equals(token)) {
                    operands.push((int)(operand2 - operand1));
                } else if ("*".equals(token)) {
                    operands.push((int)(operand1 * operand2));
                } else if ("/".equals(token)) {
                    operands.push((int)(operand2 / operand1));
                }
            } else {
                int value = Integer.valueOf(token);
                operands.push(value);
            }
        }
        return operands.peek();
        
    }
}