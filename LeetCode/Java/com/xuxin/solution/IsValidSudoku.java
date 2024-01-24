package com.xuxin.solution;

public class IsValidSudoku {
    private boolean judgeRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] temp = new int[127];
            char[] row = board[i];
            for (char cell : row) {
                if (Character.isDigit(cell)) {
                    temp[cell]++;
                }
                if (temp[cell] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean judgeCol(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] temp = new int[127];
            for (char[] row : board) {
                char cell = row[i];
                if (Character.isDigit(cell)) {
                    temp[cell]++;
                }
                if (temp[cell] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean judgeMatrix(char[][] board) {
        int[][] temp = new int[9][127];
        int count;
        for (int i = 0; i < board.length; i++) {
            if (i > 5) {
                count = 5;
            } else if (i > 2) {
                count = 2;
            } else {
                count = -1;
            }
            for (int j = 0; j < board.length; j++) {
                if (j % 3 == 0) {
                    count++;
                }
                char cell = board[i][j];
                if (Character.isDigit(cell)) {
                    temp[count][cell]++;
                }
                if (temp[count][cell] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        if (judgeRow(board) && judgeCol(board) && judgeMatrix(board)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '6', '3', '.', '.', '7', '.', '.', '.', '.' }, { '2', '.', '.', '7', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        boolean b = new IsValidSudoku().isValidSudoku(board);
        System.out.println(b);
    }
}
