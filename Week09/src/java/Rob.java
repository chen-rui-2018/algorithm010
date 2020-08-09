import model.TreeNode;

import javax.sound.midi.Soundbank;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/8/5 19:56
 * @version： v1.0
 * @modified By:
 * 打家劫舍 III
 */
public class Rob {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(1);
        root.left = root2;
        root2.left = root3;
        root3.right = root4;
        System.out.println(new Rob().rob(root));
        System.out.println(new Rob().rob2(root));
    }
    public int rob2 (TreeNode root) {
        if ( root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += (rob2(root.left.left) + rob2(root.left.right));
        }
        if (root.right != null) {
            money += (rob2(root.right.left) + rob2(root.right.right));
        }

        return Math.max(money,rob2(root.left)+ rob2(root.right));
    }
    public int rob (TreeNode root) {
      int [] result = robInternal (root);
      return Math.max(result[0],result[1]);
    }

    private int[] robInternal(TreeNode root) {
        if (root == null ) {
            return new int[2];
        }
        int [] result = new int [2];
        int [] left = robInternal(root.left);
        int [] right = robInternal(root.right);

        result [0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result [1] = left[0] + right[0] + root.val;
        return result;

    }
}
