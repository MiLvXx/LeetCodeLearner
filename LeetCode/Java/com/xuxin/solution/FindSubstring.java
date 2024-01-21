package com.xuxin.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length(), wordNum = words.length, len = s.length();

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        // 统计words数字中每个单词的出现个数
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (int windowStart = 0; windowStart < wordLength; windowStart++) {
            int windowLeft = windowStart;
            int windowRight = windowStart;

            Map<String, Integer> windowMap = new HashMap<>();

            while (windowRight + wordLength <= len) {
                /*
                 * 窗口右边界持续往后移动, 同时将经过的单词统计次数
                 */
                String word = s.substring(windowRight, windowRight + wordLength);
                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                windowRight += wordLength;

                while (windowMap.getOrDefault(word, 0) > 
                    countMap.getOrDefault(word, 0)) {
                    String leftWord = s.substring(windowLeft, windowLeft + wordLength);
                    windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                    windowLeft += wordLength;
                }

                int num = (windowRight - windowLeft) / wordLength;
                if (num == wordNum) {
                    res.add(windowLeft);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        new FindSubstring().findSubstring(s, words).forEach(ele -> System.out.println(ele));
    }
}