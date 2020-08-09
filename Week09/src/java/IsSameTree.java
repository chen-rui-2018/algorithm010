import model.TreeNode;

/**
 * @author： chenr
 * @date： Created on 2020/8/7 9:38
 * @version： v1.0
 * @modified By:
 */
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(1);
        root.left = root2;
        root2.left = root3;
        root3.right = root4;
        TreeNode newroot1 = new TreeNode(4);
        newroot1 = root;
        System.out.println( new IsSameTree().isSameTree(root,newroot1));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null &&  q == null) {
            return true;
        }
        if (p == null  ||   q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
