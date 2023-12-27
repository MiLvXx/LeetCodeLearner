package com.xuxin.solution;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        /* solution1: 使用除法 */
        // int len = nums.length;
        // int[] answer = new int[len];
        // ArrayList<Integer> zeroIndex = new ArrayList<>();
        // int product = 1;
        // for (int i = 0; i < len; i++) {
        // if (nums[i] == 0) {
        // zeroIndex.add(i);
        // continue;
        // }
        // product *= nums[i];

        // }
        // if (zeroIndex.size() > 1) {
        // Arrays.fill(answer, 0);
        // } else if (zeroIndex.size() == 1) {
        // Arrays.fill(answer, 0);
        // answer[zeroIndex.get(0)] = product;
        // } else {
        // for (int j = 0; j < len; j++) {
        // answer[j] = product / nums[j];
        // }
        // }

        // return answer;

        /* solution2: 前缀和 */
        int len = nums.length;
        int[] answer = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        s1[0] = s2[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            s1[i] = s1[i - 1] * nums[i - 1];
        }
        for (int j = len - 2; j >= 0; j--) {
            s2[j] = s2[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < len; k++) {
            answer[k] = s1[k] * s2[k];
        }
        return answer;
    }

}
