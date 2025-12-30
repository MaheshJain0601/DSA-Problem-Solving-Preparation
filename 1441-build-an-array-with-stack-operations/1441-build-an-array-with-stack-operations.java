class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int stream = 1;
        int index = 0;
        String PUSH_OPERATION = "Push";
        String POP_OPERATION = "Pop";
        while (index < target.length && stream <= n) {
            operations.add(PUSH_OPERATION);
            if (stream == target[index]) {
                index++;
            } else {
                operations.add(POP_OPERATION);
            }
            stream++;
        }
        return operations;
    }
}