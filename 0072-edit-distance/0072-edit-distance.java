class Solution {
    // Left to Right Traversal
    private int minDistanceHelper(String word1, String word2, int[][] dp, int i, int j) {
        if (i == word1.length()) {
            return dp[i][j] = word2.length() - j; // Insertions operation
        } 
        if (j == word2.length()) {
            return dp[i][j] = word1.length() - i; // Deletion operation
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistanceHelper(word1, word2, dp, i + 1, j + 1);
        } else {
            int insertionOperation = 1 + minDistanceHelper(word1, word2, dp, i, j + 1);
            int deletionOperation = 1 + minDistanceHelper(word1, word2, dp, i + 1, j);
            int replacementOperation = 1 + minDistanceHelper(word1, word2, dp, i + 1, j + 1);
            return dp[i][j] = Math.min(insertionOperation, Math.min(deletionOperation, replacementOperation));
        }
    }
    public int minDistanceRecurMemo(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minDistanceHelper(word1, word2, dp, 0, 0);
    }

    // Right to Left Traversal
    private int minDistanceHelper2(String word1, String word2, int[][] dp, int m, int n) {
        if (m == 0 || n == 0) {
            return dp[m][n] = m + n; // insertions/deletion operations
        }
        System.out.println(m + " " + n);
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (word1.charAt(m-1) == word2.charAt(n-1)) {
            return dp[m][n] = minDistanceHelper2(word1, word2, dp, m - 1, n - 1);
        } else {
            int insertionOperation = 1 + minDistanceHelper2(word1, word2, dp, m, n - 1);
            int deletionOperation = 1 + minDistanceHelper2(word1, word2, dp, m - 1, n);
            int replacementOperation = 1 + minDistanceHelper2(word1, word2, dp, m - 1, n - 1);
            return dp[m][n] = Math.min(insertionOperation, Math.min(deletionOperation, replacementOperation));
        }
    }
    public int minDistanceRecursive(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minDistanceHelper2(word1, word2, dp, word1.length(), word2.length());
    }

    // Bottom - up approach
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];
        
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    cost[i][j] = i + j;
                } else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cost[i][j] = cost[i-1][j-1];
                } else {
                    int replace = cost[i-1][j-1];
                    int delete = cost[i][j - 1];
                    int insert = cost[i - 1][j];
                    cost[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
                }
            }
        }
        return cost[m][n];
    }
}