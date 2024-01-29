package com.xuxin.solution;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        int[] hashP = new int[128];
        Map<String,Integer> hashS = new HashMap<>();
        String[] split = s.split(" ");
        
        if (len != split.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char p = pattern.charAt(i);
            String str = split[i];
            if (hashP[p] != hashS.getOrDefault(str, 0)) {
                return false;
            } else {
                if (hashP[p] == 0) {
                    hashP[p] = i+1;
                    hashS.put(str, i+1);
                }
            }
        }
        return true;
    }
}
