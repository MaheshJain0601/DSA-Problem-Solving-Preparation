class Solution {
    // Recursive Approach
    public int longestPalindromeSubseqHelper(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + longestPalindromeSubseqHelper(s, i + 1, j - 1);
        }
        int exclude_i = longestPalindromeSubseqHelper(s, i + 1, j);
        int exclude_j = longestPalindromeSubseqHelper(s, i, j - 1);

        return Math.max(exclude_i, exclude_j);
    }

    // Memoised solution
    public int longestPalindromeSubseqHelper(String s, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return dp[i][j] = 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + longestPalindromeSubseqHelper(s, dp, i + 1, j - 1);
        }
        int exclude_i = longestPalindromeSubseqHelper(s, dp, i + 1, j);
        int exclude_j = longestPalindromeSubseqHelper(s, dp, i, j - 1);

        return dp[i][j] = Math.max(exclude_i, exclude_j);
    }

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return longestPalindromeSubseqHelper(s, dp, 0, N-1);
    }
}