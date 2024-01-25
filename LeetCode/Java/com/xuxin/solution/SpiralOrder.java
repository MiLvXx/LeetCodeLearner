package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int upper = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int i = left; i <= right; i++)
                res.add(matrix[upper][i]);
            if (++upper > down)
                break;

            for (int i = upper; i <= down; i++)
                res.add(matrix[i][right]);
            if (--right < left)
                break;

            for (int i = right; i >= left; i--)
                res.add(matrix[down][i]);
            if (--down < upper)
                break;

            for (int i = down; i >= upper; i--)
                res.add(matrix[i][left]);
            if (++left > right)
                break;

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 },
        };
        new SpiralOrder().spiralOrder(matrix).forEach(
                ele -> System.out.println(ele));
    }
}
