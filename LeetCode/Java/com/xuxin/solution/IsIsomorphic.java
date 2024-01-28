package com.xuxin.solution;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[127];
        int[] mapT = new int[127];
        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (mapS[cs] != mapT[ct])
                return false;
            else {
                if (mapS[cs] == 0)
                    mapS[cs] = mapT[ct] = i + 1;

            }
        }
        return true;
    }
    public static void main(String[] args) {
        new IsIsomorphic().isIsomorphic("foo", "bar");
    }
}