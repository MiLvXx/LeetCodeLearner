package com.xuxin.solution;


public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int colLen = matrix.length;
        int rowLen = matrix[0].length;
        int[][] temp = new int[colLen][rowLen];
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
               temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (matrix[i][j] == 0) {
                    for (int col = 0; col < colLen; col++) {
                        temp[col][j] = 0;
                    }
                    for (int row = 0; row < rowLen; row++) {
                        temp[i][row] = 0;
                    }
                }
            }
        }
        System.arraycopy(temp, 0, matrix, 0, colLen);
    }
    public static void main(String[] args) {
        new SetZeroes().setZeroes(new int[][]{
            {1,1,1},
            {1,0,1},
            {1,1,1}
        });
    }
}
