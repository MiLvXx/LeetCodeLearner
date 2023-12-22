package com.xuxin.solution;

public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = prices[0];
        int maxProfit = 0;
        boolean isUp = false;
        for (int i = 1; i < prices.length; i++) {
            int prePrice = prices[i - 1];
            int currentPrice = prices[i];

            if (currentPrice > prePrice) {
                if (isUp == false) {
                    minPrice = prePrice;
                }
                if (i == prices.length - 1) {
                    maxPrice = currentPrice;
                    maxProfit += (maxPrice - minPrice);
                }
                isUp = true;
            } else {
                if (isUp == true) {
                    maxPrice = prePrice;
                    maxProfit += (maxPrice - minPrice);
                    minPrice = prePrice;
                }
                isUp = false;
            }
        }
        return maxProfit;
    }

}