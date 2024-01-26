package com.xuxin.solution;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int colLen = board.length;
        int rowLen = board[0].length;
        int[][] temp = new int[colLen][rowLen];
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                temp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                int count = 0;
                int l, r;
                l = r = j;
                // 判断有无左边界
                if (j - 1 >= 0) {
                    count += (board[i][j - 1] == 1 ? 1 : 0);
                    l = j - 1;
                }
                // 判断有无右边界
                if (j + 1 < rowLen) {
                    count += (board[i][j + 1] == 1 ? 1 : 0);
                    r = j + 1;
                }
                // 判断有无上边界
                if (i - 1 >= 0) {
                    for (int bg = l; bg <= r; bg++) {
                        count += (board[i - 1][bg] == 1 ? 1 : 0);
                    }
                }
                // 判断有无下边界
                if (i + 1 < colLen) {
                    for (int bg = l; bg <= r; bg++) {
                        count += (board[i + 1][bg] == 1 ? 1 : 0);
                    }
                }
                if (board[i][j] == 1)
                    temp[i][j] = count > 3 ? 0 : (count < 2 ? 0 : 1);
                else
                    temp[i][j] = count == 3 ? 1 : 0;
            }
        }
        System.arraycopy(temp, 0, board, 0, colLen);
    }
}
