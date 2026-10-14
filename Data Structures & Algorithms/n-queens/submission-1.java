class Solution {
    List<List<String>> boards;
    boolean isSafe(int row, int col, int n, String[][] board) {
        for(int i = 0; i < n; i++) {
            if(board[i][col].equals("Q"))
            {
                return false;
            }
        }

        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if(board[i][j].equals("Q")) {
                return false;
            }
        }

        return true;
    }
    void possible(int row, int n, String[][] board) {
        if(row == n) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            boards.add(list);
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, n, board)) {
                board[row][col] = "Q";
                possible(row+1, n, board);
                board[row][col] = ".";
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boards = new ArrayList<>();
        String[][] board = new String[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        possible(0, n, board);
        return boards;
    }
}
