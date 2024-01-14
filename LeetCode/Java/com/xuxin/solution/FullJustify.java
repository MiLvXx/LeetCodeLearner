package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int cnt = 0, bg = 0;
        for (int i = 0; i < words.length; i++) {
            cnt += words[i].length() + 1;
            // 如果是最后一个单词，或者加上下一个词就超过长度了，即可凑成一行
            if (i + 1 == words.length || cnt + words[i + 1].length() > maxWidth) {
                // 对每行单词进行空格平均划分
                res.add(fillWords(words, bg, i, maxWidth, i + 1 == words.length));
                bg = i + 1;
                cnt = 0;
            }
        }
        return res;
    }

    private String fillWords(String[] words, int bg, int ed, int maxWidth, boolean lastLine) {
        int wordCount = ed - bg + 1;
        // 除去每个单词尾部空格， + 1 是最后一个单词的尾部空格的特殊处理
        int spaceCount = maxWidth + 1 - wordCount;
        for (int i = bg; i <= ed; i++) {
            // 除去所有单词的长度
            spaceCount -= words[i].length();
        }
        // 词尾空格
        int spaceSuffix = 1;
        // 额外空格的平均值 = 总空间数/间隙数
        int spaceAvg = (wordCount == 1) ? 1 : spaceCount / (wordCount - 1);
        // 额外空格的余数
        int spaceExtra = (wordCount == 1) ? 0 : spaceCount % (wordCount - 1);
        // 填入单词
        StringBuilder sb = new StringBuilder();
        for (int i = bg; i < ed; i++) {
            sb.append(words[i]);
            if (lastLine) {
                sb.append(" ");
                continue;
            }
            int n = spaceSuffix + spaceAvg + ((i - bg) < spaceExtra ? 1 : 0);
            while (n-- > 0) {
                sb.append(" ");
            }
        }
        // 填入最后一个单词
        sb.append(words[ed]);
        // 补上这一行最后的空格
        int lastSpaceCnt = maxWidth - sb.length();
        while (lastSpaceCnt-- > 0) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
