学期总结:

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

hashMap总结
ashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,
那么对于查找，添加等操作很快，仅需一次寻址即可；如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；对于查找操作来讲，
仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。

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
 二叉树的遍历:
 前序遍历: 根左右
 中序遍历: 左根右
 后续遍历: 左右根
 
 深度优先遍历
 广度优先遍历
 
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
 
 动态规划关键点
 1.最优子结构;
 2.储存中间状态;
 3.递推公式;
 
 1.1 位运算符
 左移 （ << ）
 右移 （ >> ）
 或OR （ | ）
 与AND （&）
 取反NOT （ ～ ）
 异或XOR （ ^ ）: 相同为0，不同为1
 
 位运算实战
 
 判断奇偶：x & 1== 1为基数，==0为偶数
 x 除以2：x >> 1
 清零最低位的1：X = X & (X-1)
 得到最低位的1：X & -X
 X & ~X = 0
 
 排序算法:
 插入排序,选择排序,冒泡排序,快速排序,归并排序,堆排序;
 
 状态转移方程的推导方式;
 
 这个学期大概学习了这些内容,虽然都有了解,但是还不够熟练,尤其是动态规划内容,动态方程还是难以推导出来,
 记住坚持实施五毒神掌,多过遍数,熟能生巧;