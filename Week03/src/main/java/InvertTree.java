import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/6/23 15:48
 * @version： v1.0
 * @modified By:
 * 翻转二叉树
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode4.right = treeNode7;
        treeNode4.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode7.right = treeNode9;
        treeNode7.left = treeNode6;

        treeNode4 =  new InvertTree().invertTree(treeNode4);

        List<Integer> list = new InvertTree().inorderTraversal(treeNode4);
        for (Integer i : list){
            System.out.print(i+" ");
        }

    }

    private List<Integer> inorderTraversal(TreeNode treeNode4) {
        if (treeNode4 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
//        in_helper(treeNode4,list);
        pre_helper(treeNode4,list);
        return list;
    }

    private void pre_helper(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null){
            list.add(treeNode.val);
            if (treeNode.left != null) {
                pre_helper(treeNode.left, list);
            }
            if (treeNode.right !=null) {
                pre_helper(treeNode.right, list);
            }
        }
    }

    private void in_helper(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            if (treeNode.left != null) {
                pre_helper(treeNode.left, list);
            }
            list.add( treeNode.val);
            if (treeNode.right !=null) {
                pre_helper(treeNode.right, list);
            }
        }
    }

    /**
     * 递归 翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return  null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return  null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
             current.left = current.right;
             current.right = temp;
             if (current.left != null) {
                 queue.add(current.left);
             }
             if (current.right != null) {
                 queue.add(current.right);
             }
        }

        return root;
    }

}
