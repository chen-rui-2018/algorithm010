import model.TreeNode;

import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2020/6/24 11:38
 * @version： v1.0
 * @modified By:
 * 验证二叉搜索树
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode5.left = treeNode3;
        treeNode3.left = treeNode2;
        treeNode3.right= treeNode4;

        treeNode5.right = treeNode7;
        treeNode7.left  = treeNode6;
        treeNode7.right = treeNode9;
//        treeNode5.left = new TreeNode(-1);
        System.out.println(new ValidBST().isValidBST(treeNode5));
        System.out.println(new ValidBST().in_helper(treeNode5));
    }

    public boolean isValidBST(TreeNode root) {

        return helper(root,null,null);
    }

    /**
     * 递归
     * @param root
     * @param lower
     * @param upper
     * @return
     */

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return  true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper ) {
            return  false;
        }
        if (! helper(root.right,root.val,upper)) {
            return false;
        }
        if (! helper(root.left,lower,root.val)) {
            return false;
        }
        return true;
    }

    private boolean in_helper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;

        }
       return true;
    }
}

