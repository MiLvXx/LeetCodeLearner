package com.xuxin.solution;

import com.xuxin.util.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && check(p.left, q.right)
                && check(p.right, q.left);
    }
}