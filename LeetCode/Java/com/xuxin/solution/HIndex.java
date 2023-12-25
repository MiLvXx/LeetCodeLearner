package com.xuxin.solution;

/*
 * h代表"高引用次数", 一名科研人员的h指数是指他(她)至少发表了h篇论文,
 * 并且至少有h篇论文被引用次数大于等于h,
 * 如果h有多种可能的指, h指数指其中最大的那个
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int h = citations.length;

        while (h > 0) {
            int count = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            if (count >= h) {
                return h;
            }
            h--;
        }

        return 0;
    }

}
