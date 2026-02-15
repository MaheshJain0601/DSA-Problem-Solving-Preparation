class Solution {
    // Brute Force:
    // TC: O(2^(N + M))
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

    // Top - down approach
    // TC: O(N*M)
    // SC: O(N*M)
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

    public int longestCommonSubsequenceTopDown(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        int[][] dp = new int[N][M];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return longestCommonSubsequenceHelper(text1, text2, dp, 0, 0);
    }

    // Bottom-up approach
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        int[][] dp = new int[N+1][M+1];

        for (int r = 0; r <= N; ++r) {
            dp[r][0] = 0;
        }

        for (int c = 0; c <= M; ++c) {
            dp[0][c] = 0;
        }
        
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; ++c) {
                if (text1.charAt(r-1) == text2.charAt(c - 1)) {
                    dp[r][c] = 1 + dp[r-1][c-1];
                } else {
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }
        return dp[N][M];
    }
}