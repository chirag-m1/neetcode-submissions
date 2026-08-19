class Solution {
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    boolean present(int i, int row, int col, char[][] board, String word) {
        if(i >= word.length() || board[row][col] != word.charAt(i)) return false;

        if(i == word.length() - 1) {
            if(board[row][col] == word.charAt(i)) {
                return true;
            }
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        for(int k = 0; k < 4; k++) {
            int nRow = row + directions[k][0];
            int nCol = col + directions[k][1];
            if(nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length) {
                boolean result = present(i+1, nRow, nCol, board, word);
                if(result == true) {
                    board[row][col] = temp;
                    return true;
                }
            }
        }
        board[row][col] = temp; 
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(present(0, i, j, board, word)) return true;
            }
        }
        return false;
    }
}
