class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++) {
            HashSet<Character> row = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                if(row.contains(board[i][j])) {
                    System.out.println("row");
                    return false;
                }
                row.add(board[i][j]);
            }
        }

        for(int i = 0; i < n; i++) {
            HashSet<Character> col = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(board[j][i] == '.') continue;
                if(col.contains(board[j][i])) {
                    System.out.println("col");
                    return false;
                }
                col.add(board[j][i]);
            }
        }

        Map<String, HashSet<Character>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                int row = i / 3;
                int col = j / 3;
                String key = row + "," + col;
                if(map.containsKey(key)) {
                    if(map.get(key).contains(board[i][j])) {
                        System.out.println("square");
                        return false;
                    }
                }
                else {
                    map.put(key, new HashSet<>());
                }
                map.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}
