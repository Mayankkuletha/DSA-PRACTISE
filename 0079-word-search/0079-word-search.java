class Solution {

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        // Puri grid mein first character search karo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (solve(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean solve(char[][] board, String word,
                         int row, int col, int index) {

        // Saare characters mil gaye
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Current cell already visited / character match nahi
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Current cell ko visited mark karo
        char temp = board[row][col];
        board[row][col] = '#';

        // 4 directions
        boolean found =
            solve(board, word, row - 1, col, index + 1) ||  // up
            solve(board, word, row + 1, col, index + 1) ||  // down
            solve(board, word, row, col - 1, index + 1) ||  // left
            solve(board, word, row, col + 1, index + 1);    // right

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}