import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/6/28 16:56
 * @version： v1.0
 * @modified By:
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
     TreeNode  treeNode =     new BuildTree().buildTree(preorder,inorder);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_l, int preorder_r, int inorder_l, int inorder_r) {
        // 如果过左边界 > 右边界
        if (preorder_l > preorder_r) {
            return null;
        }
        // 前序遍历 第一个节点为树的根节点;
        int preorder_root = preorder_l;
        // 定位 中序遍历中 根节点的位置
        int inorder_root = map.get(preorder[preorder_root]);
        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树的节点数目
        int sizeLeftSubtree = inorder_root - inorder_l;
        // 递归的构造左子树, 并连接到根节点
        //先序遍历中 从左边界 +1 开始的size_left_subtree 个元素 对应了中序遍历中从左边界开始到根节点定位-1 的元素
        root.left = myBuildTree(preorder, inorder, preorder_l + 1, preorder_l + sizeLeftSubtree, inorder_l, inorder_root - 1);
        // 递归构造又子树,并连接到根节点
        // 先序遍历中 从 左边界+1+左子树的节点数目 开始到 右边界 的元素就对应了 中序遍历中 从根节点定位 +1 到右边界 的元素
        root.right = myBuildTree(preorder,inorder,preorder_l+sizeLeftSubtree+1,preorder_r,inorder_root+1,inorder_r);

        return root;
    }


}
