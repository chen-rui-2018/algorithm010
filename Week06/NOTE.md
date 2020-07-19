学习笔记
递归代码模板:
public void recur(int level, int param) {
// terminator 递归终止条件
if (level > MAX_LEVEL) {
// process result 处理结果
return;
}
// process current logic 处理当前层逻辑
process(level, param);
// drill down 下钻到下一层
recur( level: level + 1, newParam);
// restore current status 状态回滚
}

分治代码模板
def divide_conquer(problem, param1, param2, ...):
# recursion terminator
if problem is None:
print_result
return
# prepare data
data = prepare_data(problem)
subproblems = split_problem(problem, data)
# conquer subproblems
subresult1 = self.divide_conquer(subproblems[0], p1, ...)
subresult2 = self.divide_conquer(subproblems[1], p1, ...)
subresult3 = self.divide_conquer(subproblems[2], p1, ...)
…
# process and generate the final result
result = process_result(subresult1, subresult2, subresult3, …)
# revert the current level states
动态规划关键点
1.最优子结构;
2.储存中间状态;
3.递推公式;