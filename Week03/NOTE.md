学习笔记
树的递归遍历方式:


中序 左根右
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
 前序 根左右
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
 后序 左右根
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
 递归模板:
 public void recur(int level, int param) {
    // terminator 递归终止条件
    if (level > max_level) {
        // process result 返回结果(结果处理)
        return;
    }
    // process current logic 处理当前逻辑
    process(level,param);
    // drill down 递归下钻到下一层
    recur(level:level+1,newParam); 
    
    // restore current status 恢复当前层状态
 }
 
 思维要点:
 1.不要人肉递归;
 2.找到最近最简方法,拆解为可重复解决问题;(最小重复子问题)
 3.数学归纳思维;
 
 分治代码模板: 类似递归
 def divide_conquer():
    # recursion terminator  递归终止符
    if problem is None:
        print_result
        return
    # prepare data          数据准备
    data = prepare_data(problem)
    subproblems = split_problem(problem,date)
    # conquer subproblems   拆分子问题
    subresult1 = self.divide_conquer(subproblems[0],p1,...)
    subresult2 = self.divide_conquer(subproblems[1],p1,...)
    ...
    # process an generate the final result  处理并生成最终结果
    result = process_result(subresult1, subresult2, subresult3, ...) 
    # revert the current level states  恢复当前级别状态
  回溯:
  回溯法采用试错的思想，它尝试分步的去解决一个问题。
  在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，
  它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
  回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
   1.找到一个可能存在的正确的答案；
   2.在尝试了所有可能的分步方法后宣告该问题没有答案。 
   在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。
