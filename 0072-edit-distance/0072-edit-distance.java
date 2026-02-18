class Solution {
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
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minDistanceHelper(word1, word2, dp, 0, 0);
    }
}