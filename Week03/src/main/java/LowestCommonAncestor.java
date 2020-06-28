import model.TreeNode;

/**
 * @author： chenr
 * @date： Created on 2020/6/28 11:25
 * @version： v1.0
 * @modified By:
 * 二叉树的最近公共祖先
 *
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t6.right = t2;
        t2.left = t7;
        t2.right = t4;
        t1.left = t0;
        t1.right = t8;
        LowestCommonAncestor  lca = new    LowestCommonAncestor();
        lca.treeNode = lca.lowestCommonAncestor(t3,t5,t1);
        System.out.println(lca.treeNode.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return treeNode;
    }
    private TreeNode treeNode = null;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if  (root == null ) {
            return false;
        }
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        boolean condition1 = lson && rson;
        boolean condition2 = (root.val == p.val || root.val == q.val) && (lson || rson) ;

        if (condition1 || condition2 ) {
            treeNode = root;
        }
        return  lson || rson || (root.val == p.val || root.val == q.val) ;
    }


}
