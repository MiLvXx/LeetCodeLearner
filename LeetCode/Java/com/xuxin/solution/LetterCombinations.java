package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    private char[] path;
    private char[] digits;
    private List<String> res = new ArrayList<>();
    private Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return List.of();

        path = new char[digits.length()];
        this.digits = digits.toCharArray();

        dfs(0);

        return res;

    }

    private void dfs(int i) {
        if (i == digits.length) {
            res.add(String.valueOf(path));
            return;
        }

        for (char c : map.get(digits[i]).toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }

}
