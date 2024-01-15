package com.xuxin.solution;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        else if (t.isEmpty())
            return false;

        int si = 0;
        int ti = 0;
        for (;;) {
            if (s.charAt(si) == t.charAt(ti)) {
                if (++si == s.length())
                    return true;
            }

            if (++ti == t.length())
                break;
        }

        return false;
    }

}
