class Solution {
    // Brute Force:
    // TC: O(2^N)
    public int longestCommonSubsequenceHelperBrute(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceHelperBrute(text1, text2, i+1, j+1);
        }

        int exclude_i = longestCommonSubsequenceHelperBrute(text1, text2, i + 1, j);
        int exclude_j = longestCommonSubsequenceHelperBrute(text1, text2, i, j + 1);

        return Math.max(exclude_i, exclude_j);
    }

    public int longestCommonSubsequenceHelper(String text1, String text2, int[][] dp, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequenceHelper(text1, text2, dp, i+1, j+1);
        }

        int exclude_i = longestCommonSubsequenceHelper(text1, text2, dp, i + 1, j);
        int exclude_j = longestCommonSubsequenceHelper(text1, text2, dp, i, j + 1);

        return dp[i][j] = Math.max(exclude_i, exclude_j);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        int[][] dp = new int[N][M];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return longestCommonSubsequenceHelper(text1, text2, dp, 0, 0);
    }
}