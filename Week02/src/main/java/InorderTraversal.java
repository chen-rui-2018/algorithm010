import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author： chenr
 * @date： Created on 2020/6/16 22:37
 * @version： v1.0
 * @modified By:
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.right = treeNode5;
        treeNode1.left =treeNode2;
        treeNode2.right = treeNode4;
        treeNode2.left = treeNode3;
        treeNode5.left = treeNode6 ;
        treeNode5.right = treeNode8  ;
        treeNode6.right= treeNode7;
        List<Integer> list = new InorderTraversal().inorderTraversal(treeNode1);
        for (Integer i : list){
            System.out.print(i+" ");
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();

//        helper_in(root,nodeList);
//        helper_pre(root,nodeList);
//        helper_post(root,nodeList);

        helper_post(root,nodeList);

        return nodeList;
    }

    /**
     * 中序遍历
     * @param root
     * @param nodeList
     */
    private void helper_in(TreeNode root, List<Integer> nodeList) {
        if (root != null){
            if (root.left != null){
                helper_in(root.left,nodeList);
            }
            nodeList.add(root.val);
            if (root.right != null){
                helper_in(root.right,nodeList);
            }
        }

    }

    /**
     * 中序遍历2 --  栈
     * @param root
     * @param nodeList
     */
    private void helper_in2(TreeNode root, List<Integer> nodeList) {
        Stack<TreeNode> stack = new Stack<>();
        while (! stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodeList.add(root.val);
            root = root.right;

        }

    }

    /**
     * 前序遍历
     * @param root
     * @param nodeList
     */
    private void helper_pre(TreeNode root, List<Integer> nodeList) {
        if (root != null){
            nodeList.add(root.val);
            if (root.left != null){
                helper_pre(root.left,nodeList);
            }
            if (root.right != null){
                helper_pre(root.right,nodeList);
            }
        }

    }
    /**
     * 后序遍历
     * @param root
     * @param nodeList
     */
    private void helper_post(TreeNode root, List<Integer> nodeList) {
        if (root != null){
            if (root.left != null){
                helper_post(root.left,nodeList);
            }
            if (root.right != null){
                helper_post(root.right,nodeList);
            }
            nodeList.add(root.val);
        }

    }
}
