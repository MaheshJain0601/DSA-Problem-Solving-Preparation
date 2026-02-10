class Solution {
    // Approach-1
    // TC: O(N!)
    // SC: O(N)
    public List<List<String>> solveNQueensBrute(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0)
            return result;
        
        List<String> board = new ArrayList<>();
        // For n = 3, board = {"...", "...", "..."} initially
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        solve(board, result, 0);
        
        return result;
    }

    private void solve(List<String> board, List<List<String>> result, int row) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        // Place one queen at every row and check before placing
        // in every direction where there is a risk of being attacked
        // i.e., up, diagonally because we are placing queens from
        // the top row to the bottom row, so we need to check if we put a queen
        // vertically up in some row or diagonally upwards in some row

        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, row, col)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(board, result, row + 1);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        // Look for up
        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }

        // Check left diagonal upwards
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        // Check right diagonal upwards
        for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        return true;
    }

    // Approach-2
    

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0)
            return result;

        List<String> board = new ArrayList<>();
        // For, n = 3, board = {"...", "...", "..."} initially
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        int startRow = 0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();
        solve(board, result, startRow, cols, diags, antiDiags);

        return result;
    }

    private void solve(List<String> board, List<List<String>> result, int row, Set<Integer> cols, Set<Integer> diags, Set<Integer> antiDiags) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        /*
         * For a square (i, j) : Diagonally (i-j) is constant Anti diagonally (i+j) is
         * constant
         * 
         * We can use this to find which square (i, j) has a risk of being attacked
         * by another queen placed already in 'diagonal', or 'anti-diagonal' or
         * 'column'
         */

        for (int col = 0; col < board.size(); col++) {
            int diagId = row - col;
            int antiDiagId = row + col;

            /*
             * If the col, or diagonal or anti_diagonal are used means one of them has a
             * Queen placed already which can attack, so look for other column
             */
            if (cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId))
                continue;

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);

            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solve(board, result, row + 1, cols, diags, antiDiags);

            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
}