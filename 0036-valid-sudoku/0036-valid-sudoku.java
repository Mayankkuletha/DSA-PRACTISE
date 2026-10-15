class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i<9 ; i++){

            for(int j = 0 ; j<9 ; j++){

                if(board[i][j]=='.') continue;

                if(!isValid(board , i , j  , board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char [][] board , int row , int col , char digit){

        //rows and col
            for (int k = 0 ; k<9 ; k++){
                if(k!=col && board[row][k] == digit) return false;
                if(k!=row && board[k][col]==digit) return false;
            }
        
        //for box
        int startrow = (row/3) *3;
        int startcol = (col/3) *3;
        
        for(int i = 0 ; i< 3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                int c = startrow + i;
                int d = startcol+j;
                if((c!=row || d!=col) && board[c][d]==digit) return false;
            }
        }
        return true;
    }
}