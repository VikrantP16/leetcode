class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];
    private List<int[]> emptyCells = new ArrayList<>();
    
    public void solveSudoku(char[][] board) {
        // Initialize constraints
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        
        solve(board, 0);
    }
    
    private boolean solve(char[][] board, int idx) {
        if (idx == emptyCells.size()) {
            return true;
        }
        
        int row = emptyCells.get(idx)[0];
        int col = emptyCells.get(idx)[1];
        int boxIdx = (row / 3) * 3 + col / 3;
        
        for (int num = 0; num < 9; num++) {
            if (!rows[row][num] && !cols[col][num] && !boxes[boxIdx][num]) {
                // Place number
                board[row][col] = (char) ('1' + num);
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[boxIdx][num] = true;
                
                if (solve(board, idx + 1)) {
                    return true;
                }
                
                // Backtrack
                board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                boxes[boxIdx][num] = false;
            }
        }
        
        return false;
    }
}