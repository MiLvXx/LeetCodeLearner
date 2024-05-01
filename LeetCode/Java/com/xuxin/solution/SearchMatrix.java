package com.xuxin.solution;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /* Solution1:
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length-1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
        */

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (target > row[row.length-1]) {
                continue;
            }
            if (target < row[0]) {
                return false;
            }
            int left = 0, right = row.length-1;
            while (left <= right) {
                int mid = left + (right-left)/2;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] > target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        new SearchMatrix().searchMatrix(new int[][]{{1}, {3}}, 3);
    }
}
