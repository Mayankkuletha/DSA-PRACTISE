class Solution {

    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonal = new HashSet<>();
    Set<Integer> antidiagonal = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // board ko '.' se fill karna
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(n, board, 0);

        return result;
    }

    public void solve(int n, char[][] board, int row) {

        // saari rows mein queen place ho gayi
        if(row >= n) {

            List<String> current = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            result.add(current);
            return;
        }

        // current row mein har column try karo
        for(int col = 0; col < n; col++) {
           
           if(cols.contains(col) || diagonal.contains(row+col) || antidiagonal.contains(row-col)){
            continue;
           }
           cols.add(col);
           diagonal.add(row + col);
           antidiagonal.add(row-col);

           board[row][col] ='Q';
           solve(n , board , row+1);
           board[row][col] = '.';
           
           //if recursion fails then we have to remove those coordinates from set.
           cols.remove(col);
           diagonal.remove(row + col);
           antidiagonal.remove(row-col);
        }
    }
}