import model.TreeNode;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/7/2 9:58
 * @version： v1.0
 * @modified By:
 * 在每个树行中找最大值
 */
public class LargestValues {
    public static void main(String[] args) {
        TreeNode treeNod1 = new TreeNode(1);
        TreeNode treeNod2 = new TreeNode(2);
        TreeNode treeNod3 = new TreeNode(3);
        TreeNode treeNod4 = new TreeNode(5);
        TreeNode treeNod5 = new TreeNode(3);
        TreeNode treeNod6 = new TreeNode(9);
        treeNod1.left = treeNod3;
        treeNod1.right = treeNod2;
        treeNod3.left = treeNod5;
        treeNod3.right = treeNod4;
        treeNod2.right = treeNod6;
//        List<Integer> result = new LargestValues().largestValues(treeNod1);
        List<Integer> result = new LargestValues().largestValues2(treeNod1);
        for (Integer integer : result) {
            System.out.println(integer);
        }

    }
    /** 广度优先 */
    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while ( !queue.isEmpty()) {
            int size = queue.size();
            int maxValue = (int ) -Double.MAX_VALUE;
            for (int i = 0; i < size; i++ ) {
                TreeNode  temp = queue.remove();
                maxValue  = Math.max(temp.val,maxValue);
                if (temp .left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(maxValue);
        }
        return result;
    }
    /** 深度优先 */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null ) {
            return;
        }
        if (level == res.size() + 1) {
            res.add(root.val);
        }else {
            res.set(level-1,Math.max(res.get(level-1),root.val));
        }
        helper(root.left,res,level+1);
        helper(root.right,res,level+1);

    }


}
