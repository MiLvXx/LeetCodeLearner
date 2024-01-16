package com.xuxin.solution;

public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0;
        while (i < j) {
            if (Math.min(height[i], height[j]) * (j - i) > area) {
                area = Math.min(height[i], height[j]) * (j - i);
            }
            if (height[i] > height[j]) {
                j--;
            } else if (height[i] < height[j]) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return area;
    }
}
