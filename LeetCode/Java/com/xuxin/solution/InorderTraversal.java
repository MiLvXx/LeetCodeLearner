package com.xuxin.solution;

import java.util.ArrayList;
import java.util.List;

import com.xuxin.util.TreeNode;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }
}
