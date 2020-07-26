import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/6/30 10:50
 * @version： v1.0
 * @modified By:
 * 二叉树的层序遍历
 */
public class LevelOrder  {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;
        t1.left = t5;
        t1.right = t6;
        List<List<Integer>> res = new LevelOrder().levelOrder1(t0);


    }

    /**
     * 迭代遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

         // 结果集
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 要遍历的目标列表
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            List<Integer>  temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node =  ((LinkedList<TreeNode>) queue).remove();
                temp.add(node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {

        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(1,root,res);
        return res;
    }

    private void dfs(int level, TreeNode root, List<List<Integer>> res) {
        if (res.size() < level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level-1).add(root.val);
        if (root.left != null) {
            dfs(level+1,root.left,res);
        }
        if (root.right != null) {
            dfs(level+1,root.right,res);
        }
    }
}
