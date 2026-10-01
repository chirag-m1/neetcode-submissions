class Solution {
    void dfs(int i, int j, char[][] board, int rows, int cols) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || board[i][j] == '1') {
            return;
        }
        board[i][j] = '1';
        dfs(i+1, j, board, rows, cols);
        dfs(i-1, j, board, rows, cols);
        dfs(i, j+1, board, rows, cols);
        dfs(i, j-1, board, rows, cols);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board, rows, cols);
            }
            if(board[i][cols-1] == 'O') {
                dfs(i, cols-1, board, rows, cols);
            }
        }    

        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, board, rows, cols);
            }
            if(board[rows-1][i] == 'O') {
                dfs(rows-1, i, board, rows, cols);
            }
        }  

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
