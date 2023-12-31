package com.xuxin.solution;

import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
                'I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500,
                'M', 1000);

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int romanInt = romanMap.get(s.charAt(i));
            if (i == s.length() - 1) {
                return num + romanInt;
            }
            int pre = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i+1));
            if (next > pre) {
                num += next - pre;
                i++;
                continue;
            }
            num += romanInt;
        }
        return num;
    }
}
