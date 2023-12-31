package com.xuxin.solution;

public class Trap {
    public int trap(int[] height) {
        int rain = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for(int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }

            int max_right = 0;
            for (int j = i+1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }

            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                rain += (min - height[i]);
            }
        }
        return rain;
        
    }
    public static void main(String[] args) {
        System.out.println(new Trap().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
