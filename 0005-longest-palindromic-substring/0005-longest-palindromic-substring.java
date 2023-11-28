class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        int max_start = 0, max_end = 0;
        
        boolean[][] isPalindromeSubResult = new boolean[N][N];
        // default false populate
        for (boolean[] isPalindromeSubRow: isPalindromeSubResult) {
            Arrays.fill(isPalindromeSubRow, false);
        }
        
        // single character handling
        for (int i = 0; i < N; ++i) {
            isPalindromeSubResult[i][i] = true;
        }
        
        // two character handling
        for (int i = 0; i < N-1; ++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalindromeSubResult[i][i+1] = true;
                max_start = i;
                max_end = i+1;
            }
        }
        
        // other substring handling
        for (int col = 2; col < N; ++col) {
            for (int row = 0; row < N - 2; ++row) {
                int index = row + col;
                
                if (index == N) {
                    break;
                }
                
                if (isPalindromeSubResult[row + 1][index - 1] && s.charAt(row) == s.charAt(index)) {
                    isPalindromeSubResult[row][index] = true;
                    if (index - row > max_end - max_start) {
                        max_start = row;
                        max_end = index; 
                    }
                }
            }
        }
        
        
        return s.substring(max_start, max_end+1);
        
    }
}