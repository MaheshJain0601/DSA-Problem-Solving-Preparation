class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Map<String, BiFunction<Long, Long, Integer>> operation = new HashMap<>();
        operation.put("+", (a, b) -> (int)(a + b));
        operation.put("-", (a, b) -> (int)(a - b));
        operation.put("*", (a, b) -> (int)(a * b));
        operation.put("/", (a, b) -> (int)(a / b));
        
        for (String token: tokens) {
            if (operation.containsKey(token)) {
                Long operand2 = (long) operands.pop();
                Long operand1 = (long) operands.pop();
                operands.push(operation.get(token).apply(operand1, operand2));
            } else {
                int value = Integer.valueOf(token);
                operands.push(value);
            }
        }
        return operands.peek();
        
    }
}