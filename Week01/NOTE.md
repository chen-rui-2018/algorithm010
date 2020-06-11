学习笔记:
1.编程方式: 自顶向下的编程方式,就是先列出主流程操作,然后再顾及旁支细节;
2.时间复杂度:常见的7种;
(1)O(1):Constant Complexity 常数复杂度    --    每行只执行一次
(2)O(log n): Logarithmic Complexity 对数复杂度  -- for (int i = 1; i < n; i = i * 2) {);                                              }
(3)O(n): Linear Complexity 线性时间复杂度  -- 正常单次循环
(4)O(n^2) : N square Complexity 平方     -- 正常两层嵌套循环
(5)O(n^3): N cubic Complexity 立方      -- 正常三层嵌套循环 
(6)O(2^n):Exponential Growth 指数      --
(7)O(n!) : Factorial 阶乘             -- 递归 斐波拉契序列

多代码段,只看最高复杂度的运算  

二叉树遍历 - 前序、中序、后序：O(N) -- 全部节点最多只遍历一次
图的遍历：O(N)                   -- 全部节点最多只遍历一次               
搜索算法：DFS、BFS - O(N)        -- 全部节点最多只遍历一次
二分查找：O(logN)              -- 每次减少1/2的遍历量

3.空间复杂度
(1) 数组的长度
(2) 递归的深度

4:数组(Array ):内存连续,查找O(1),增删O(n)特殊情况下可能是O(1)--加到最后;
5:链表(Linked List):以节点为单位,包含value和指针指向下一个节点(单链表),双向链表则还会有指向上一个节点的指针;
时间复杂度
prepend O(1)
append O(1)
lookup O(n)
insert O(1)
delete O(1)

6:跳表(Skip List):有序链表的升维,给有序链表增加索引,给索引再增加索引,减少查询目标的次数,已空间换时间;
n/2、n/4、n/8、第 k 级索引结点的个数就是 n/(2^k)
假设索引有 h 级，最高级的索引有 2 个结点。n/(2^h) = 2，
从而求得 h = log2(n)-1