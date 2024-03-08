package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int a = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                a++;
            }
        }
        for (int l = 0, r = 0, b = 0; r < n; r++) {
            if (--cnt[s.charAt(r) - 'a'] == 0) {
                b++;
            }

            if (r - l + 1 > m && ++cnt[s.charAt(l++) - 'a'] == 1) {
                b--;
            }

            if (b == a) {
                res.add(l);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        new FindAnagrams().findAnagrams(s, p);
    }
}
