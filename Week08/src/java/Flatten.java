import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/8/2 12:29
 * @version： v1.0
 * @modified By:
 */
public class Flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3= new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root.left = root2;
        root.right = root5;
        root2.left = root3;
        root2.right = root4;
        root5.right = root6;

//        new Flatten().flatten(root);
        new Flatten().flatten2(root);

    }
    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        helper(root,nodeList);
        int size = nodeList.size();

        for (int i = 1; i < size; i++) {
            TreeNode prev = nodeList.get(i-1);
            TreeNode curr = nodeList.get(i);
            prev.right = curr;
            prev.left = null;

        }
    }
    private void helper(TreeNode root, List<TreeNode> nodeList) {
        if(root != null){
            nodeList.add(root);
            helper(root.left,nodeList);
            helper(root.right,nodeList);
        }
    }

    public void flatten2(TreeNode root){

        List<TreeNode> nodeList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null) {
                nodeList.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = nodeList.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = nodeList.get(i-1);
            TreeNode curr = nodeList.get(i);
            prev.right = curr;
            prev.left = null;
        }
    }
}
