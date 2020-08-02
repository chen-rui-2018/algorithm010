import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/7/28 9:38
 * @version： v1.0
 * @modified By:
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);
        node3.left= node9;
        node3.right = node20;
        node9.left = node7;
        node20.left = node15;
      int result =   new MaxDepth().maxDepth(node3);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size =   queue.size();
            while (size > 0) {
                TreeNode curr = queue.remove();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
}

