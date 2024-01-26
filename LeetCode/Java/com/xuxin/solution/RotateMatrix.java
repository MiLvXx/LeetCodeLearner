package com.xuxin.solution;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int colLen = matrix.length;
        int rowLen = matrix[0].length;

        int[][] temp = new int[colLen][rowLen];
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                temp[j][colLen - i - 1] = matrix[i][j];
            }
        }
        System.arraycopy(temp, 0, matrix, 0, colLen);
    }
}
