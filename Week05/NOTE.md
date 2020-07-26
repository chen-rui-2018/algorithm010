学习笔记
1.二叉树结构模板
public class TreeNode {
public int val;
public TreeNode left, right;
public TreeNode(int val) {
this.val = val;
this.left = null;
this.right = null;
}
}
2.深度优先模板 先从根到左子树最深节点,依次回溯访问每枝条最深节点
visited = set()
def dfs(node, visited):
if node in visited: # terminator
# already visited
return
visited.add(node)
# process current node here.
...
for next_node in node.children():
if not next_node in visited:
dfs(next node, visited
3.广度优先 -- 按层次遍历
def BFS(graph, start, end):
queue = []
queue.append([start])
visited.add(start)
while queue:
node = queue.pop()
visited.add(node)
process(node)
nodes = generate_related_nodes(node)
queue.push(nodes)
# other processing work
...

贪心算法:
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有
利）的选择，从而希望导致结果是全局最好或最优的算法。
贪心法可以解决一些最优化问题，如：求图中的最小生成树、求哈夫曼编码
等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答
案。
一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最
好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心
法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。


二分查找:
二分查找的前提:
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

代码模版
left, right = 0, len(array) - 1
while left <= right:
mid = (left + right) / 2
if array[mid] == target:
# find the target!!
break or return result
elif array[mid] < target:
left = mid + 1
else:
right = mid - 1

使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方:
相当于找到数组中最小值的下标minIndex
1.首先计算 mid = (left + right) / 2
2.比较 nums[0] 和 nums[mid];如果 nums[mid] > nums[0],那么 min< minIndex <length-1,否则0<minIndex<mid
3.然后按照步骤2继续二分,最后剩下的元素下标即为目标值;

