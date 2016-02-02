import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    ArrayList<TreeNode> children;
    TreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

class TreeNodeWrapper {
    TreeNode node;
    int maxDepth;
    TreeNodeWrapper(TreeNode node, int maxDepth) {
        this.node = node;
        this.maxDepth = maxDepth;
    }
}

class Solution {
    public TreeNode find(TreeNode root) {
        if (root == null || root.children.isEmpty()) {
            return root;
        }
        return helper(root).node;
    }
    
    public TreeNodeWrapper helper(TreeNode root) {
        if (root.children.isEmpty()) {
            return new TreeNodeWrapper(root, 1);
        }
        
        int maxDepth = Integer.MIN_VALUE;
        int size = root.children.size();
        TreeNodeWrapper r = new TreeNodeWrapper(root, maxDepth);
        
        for (int i = 0; i < size; i++) {
            TreeNodeWrapper wrapper = helper(root.children.get(i));
            if (wrapper.maxDepth > maxDepth) {
                maxDepth = wrapper.maxDepth;
                r.node = (maxDepth == 1? root: wrapper.node);
                r.maxDepth = wrapper.maxDepth + 1;
            } else if (wrapper.maxDepth == maxDepth) {
                r.node = root;
            }        
        }
        return r;
    }
}

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        n4.children.add(n7);
        n5.children.add(n8);
        n5.children.add(n9);
        n6.children.add(n10);
        TreeNode res = sol.find(n1);
        System.out.println(res.val);
    }
}