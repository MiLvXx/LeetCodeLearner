package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode77.组合:
 * 给定两个整数 n 和 k ,返回范围 [1, n] 中所有可能的
 * K个数的组合
 */
public class Combine {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
      
        path = new ArrayList<>();
        dfs(n, k);

        return res;
    }

    private void dfs(int n, int k) {
        int rest = k - path.size();  // 还要选 rest 个数
        if (rest == 0) {
            res.add(new ArrayList<>(path));  // 不能直接写 res.add(path) 
            return;
        }

        for (int j = n; j >= rest; --j) {
            path.add(j);
            dfs(j-1, k);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Combine().combine(4, 2);
    }
}
