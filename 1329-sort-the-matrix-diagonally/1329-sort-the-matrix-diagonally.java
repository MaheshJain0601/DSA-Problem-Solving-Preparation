class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < rows; ++i) 
            for (int j = 0; j < cols; ++j) 
                map.computeIfAbsent(i-j, k -> new PriorityQueue<>()).offer(mat[i][j]);
        

        for (int i = 0; i < rows; ++i) 
            for (int j = 0; j < cols; ++j) 
                mat[i][j] = map.get(i-j).poll();

        return mat;
    }
}