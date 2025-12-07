class Solution {
    private void reverse(List<Integer> nums, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                map.computeIfAbsent(i+j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        int[] result = new int[rows * cols];
        boolean flip = true;
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (flip)
                reverse(entry.getValue(), 0, entry.getValue().size() - 1);
            
            for (int num: entry.getValue()) 
                result[index++] = num;
                
            flip = !flip;
        }
        return result;
    }
}