package leetcode.dfs;

public class SurroundArea {
    /**
     * 被 围绕的区域
     */
    public void solve(char[][] board) {
        int row = board.length - 1;
        int column = board[0].length - 1;
        boolean[][] visit = new boolean[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            if (board[i][0] == 'O' && !visit[i][0]) {
                board[i][0] = 'A';
                dfsBoard(i, 0, row, column, board, visit);
            }
        }
        for (int j = 0; j <= column; j++) {
            if (board[0][j] == 'O' && !visit[0][j]) {
                board[0][j] = 'A';
                dfsBoard(0, j, row, column, board, visit);
            }
        }
        for (int j = 0; j <= column; j++) {
            if (board[row][j] == 'O' && !visit[row][j]) {
                board[row][j] = 'A';
                dfsBoard(row, j, row, column, board, visit);
            }
        }
        for (int i = 0; i <= row; i++) {
            if (board[i][column] == 'O' && !visit[i][column]) {
                board[i][column] = 'A';
                dfsBoard(i, column, row, column, board, visit);
            }
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (board[i][j] != 'A') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfsBoard(int i, int j, int row, int column, char[][] board, boolean[][] visit) {
        if (i > row || j > column || i < 0 || j < 0) {
            return;
        }
        //如果不是 'O'
        if (board[i][j] == 'X' || visit[i][j] || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        dfsBoard(i + 1, j, row, column, board, visit);
        dfsBoard(i - 1, j, row, column, board, visit);
        dfsBoard(i , j +1, row, column, board, visit);
        dfsBoard(i , j-1, row, column, board, visit);
    }
}
