class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                map.computeIfAbsent(i-j, k -> new LinkedList<>()).add(mat[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        

        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                mat[i][j] = map.get(i-j).getLast();
                map.get(i-j).removeLast();
            }
        }

        return mat;
    }
}