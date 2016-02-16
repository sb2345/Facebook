TreeNode buildTree(int[] arr, int left ,int right) {
    if (left > right) {
        return null;
    }
    int min = arr[left], index = left;
    for (int i = left + 1; i <= right; i++) {
        if (arr[i] < min) {
            min = arr[i];
            index = i;
        }
    }
    TreeNode root = new TreeNode(min);
    root.left = buildTree(arr, left, index - 1);
    root.right = buildTree(arr, index + 1, right);
    return root;
}

TreeNode addNode(TreeNode root, int val) {
    TreeNode inserted = new TreeNode(val);
    if (val <= root.val) {
        inserted.left = root;
        return inserted;
    }
    TreeNode curr = root.right, prev = root;
    while (curr != null) {
        if (val <= curr.val) {
            inserted.left = curr;
            prev.right = inserted;
            return root;
        } else {
            prev = curr;
            curr = curr.right;
        }
    }
    prev.right = inserted;
    return root;
}