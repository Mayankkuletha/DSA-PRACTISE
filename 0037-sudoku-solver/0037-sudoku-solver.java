class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Find an empty cell
                if (board[i][j] == '.') {

                    // Try digits 1 to 9
                    for (char digit = '1'; digit <= '9'; digit++) {

                        if (isValid(board, digit, i, j)) {

                            board[i][j] = digit;

                            // If solved, stop recursion
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[i][j] = '.';
                        }
                    }

                    // No digit works in this cell
                    return false;
                }
            }
        }

        // No empty cell remains
        return true;
    }

    public boolean isValid(
        char[][] board, char digit, int row, int col
    ) {

        // Check row and column
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == digit) {
                return false;
            }

            if (board[i][col] == digit) {
                return false;
            }
        }

        // Find the starting position of the 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check the 3x3 box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[startRow + i][startCol + j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
}