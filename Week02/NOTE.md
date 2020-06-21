学习笔记
hashMap 总结
HashMap 的 主干是一个Entry数组.Entry是HashMap的基本组成单元,每一个Entry包含一个key-value 键值对;
transient Entry<k,v>[] table = (Entry<k,v>[]) EMPTY_TABLE;
Entry 是 HashMap 中的一个静态内部类.
static class Entry<k,v> implements Map.Entry<k,v>{
    final k key;
    v value;
    // 存储指向下一个Entry的引用,单链表结构;
    Entry<k,v> next;
    // 对key 的hashcode值进行hash运算后得到的值,存在Entry,避免重复计算;
    int hash;
    
    //创建一个新的 entry
    Entry (int h,K k,V v,Entry<K,V> n){
    value = v;
    next = n;
    key = k;
    hash = h;
    }
}

简单来说，HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,
那么对于查找，添加等操作很快，仅需一次寻址即可；如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；对于查找操作来讲，
仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。


发生冲突关于entry节点插入链表还是链头呢？
JDK7:插入链表的头部，头插法
JDK8:插入链表的尾部，尾插法


put方法:
public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }

        modCount++;
        addEntry(hash, key, value, i);
        return null;
    }
    如果遍历链表都没法发现相应的key值的话，则会调用addEntry方法在链表添加一个Entry，重点就在与addEntry方法是如何插入链表的，addEntry方法源码如下
    
     void addEntry(int hash, K key, V value, int bucketIndex) {
        Entry<K,V> e = table[bucketIndex];
            table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
            if (size++ >= threshold)
                resize(2 * table.length);
        }
        
        这里构造了一个新的Entry对象（构造方法的最后一个参数传入了当前的Entry链表），然后直接用这个新的Entry对象取代了旧的Entry链表，看一下Entry的构造方法可以知道是头插法
       从构造方法中的next=n可以看出确实是把原本的链表直接链在了新建的Entry对象的后边，可以断定是插入头部。
        Entry( int h, K k, V v, Entry<K,V> n) {
                value = v;
                next = n;
                key = k;
                hash = h;
        }
        jdk8:
        还是继续查看put方法的源码查看插入节点的代码：
        从这段代码中可以很显然地看出当到达链表尾部（即p是链表的最后一个节点）时，e被赋为null，会进入这个分支代码，然后会用newNode方法建立一个新的节点插入尾部。
        //e是p的下一个节点
        if ((e = p.next) == null) {
           //插入链表的尾部
           p.next = newNode(hash, key, value, null);
           //如果插入后链表长度大于8则转化为红黑树
           if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
               treeifyBin(tab, hash);
           break;
        }
hashMap的默认长度和扩容问题:
摘自https://www.jianshu.com/p/a7767e6ff2a2
1.为什么HashMap的Entry数组长度默认为16呢?为什么数组长度一定要是2的n次幂呢？

查看HashMap计算hashcode的方法获取存储的位置：
为了减少hash值的碰撞,需要实现一个尽量均匀分布的hash函数,在HashMap中通过利用key的hashcode值,来进行位运算
举个例子
1.计算"book"的hashcode
十进制 : 3029737
二进制 : 101110001110101110 1001

2.HashMap长度是默认的16，length - 1的结果
十进制 : 15
二进制 : 1111

3.把以上两个结果做与运算
101110001110101110 1001 & 1111 = 1001
1001的十进制 : 9,所以 index=9

结论：hash算法最终得到的index结果,取决于hashcode值的最后几位
现在,我们假设HashMap的长度是10,重复刚才的运算步骤:
hashcode : 101110001110101110 1001
length - 1 :                                     1001
index :                                           1001

再换一个hashcode 101110001110101110 1111 试试:
hashcode : 101110001110101110 1111
length - 1 :                                    1001
index :                                           1001
从结果可以看出,虽然hashcode变化了,但是运算的结果都是1001,也就是说,当HashMap长度为10的时候,有些index结果的出现几率会更大而有些index结果永远不会出现(比如0111),这样就不符合hash均匀分布的原则。
反观长度16或者其他2的幂,length - 1的值是所有二进制位全为1,这种情况下,index的结果等同于hashcode后几位的值，只要输入的hashcode本身分布均匀,hash算法的结果就是均匀的。

HashMap的默认长度为16和规定数组长度为2的幂,是为了降低hash碰撞的几率;

2.HashMap扩容限制的负载因子为什么是0.75呢？为什么不能是0.1或者1呢？

由HashMap的put方法中实现中的addEntry的实现代码可知当数组长度达到限制条件的阈值就要进行数组的扩容。
扩容的方式是：
新建一个长度为之前数组2倍的新的数组，然后将当前的Entry数组中的元素全部传输过去，扩容后的新数组长度为之前的2倍，所以扩容相对来说是个耗资源的操作。
扩容的触发条件：
阈值 = 数组默认的长度 x 负载因子（阈值=16x0.75=12）
threshold = (int)(capacity * loadFactor);
void addEntry(int hash, K key, V value, int bucketIndex) {
        if ((size >= threshold) && (null != table[bucketIndex])) {
            resize(2 * table.length);//当size超过临界阈值threshold，并且即将发生哈希冲突时进行扩容
            hash = (null != key) ? hash(key) : 0;
            bucketIndex = indexFor(hash, table.length);
        }

        createEntry(hash, key, value, bucketIndex);
    }

由上面的内容可知，

如果负载因子为0.5甚至更低的可能的话，最后得到的临时阈值明显会很小，这样的情况就会造成分配的内存的浪费，存在多余的没用的内存空间，也不满足了哈希表均匀分布的情况。
如果负载因子达到了1的情况，也就是Entry数组存满了才发生扩容，这样会出现大量的哈希冲突的情况，出现链表过长，因此造成get查询数据的效率。
因此选择了0.5~1的折中数也就是0.75，均衡解决了上面出现的情况。





        
get方法:
      
 public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
 getNode 方法
 final Node<K,V> getNode(int hash, Object key) {
         Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
         if ((tab = table) != null && (n = tab.length) > 0 &&
             (first = tab[(n - 1) & hash]) != null) {
             if (first.hash == hash && // always check first node
                 ((k = first.key) == key || (key != null && key.equals(k))))
                 return first;
             if ((e = first.next) != null) {
                 if (first instanceof TreeNode)
                     return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                 do {
                     if (e.hash == hash &&
                         ((k = e.key) == key || (key != null && key.equals(k))))
                         return e;
                 } while ((e = e.next) != null);
             }
         }
         return null;
     }
 // node 相当于 entry
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
get总结:
计算 key 的 hash 值，根据 hash 值找到对应数组下标: hash & (length-1)
判断数组该位置处的元素是否刚好就是我们要找的，如果不是，走第三步
判断该元素类型是否是 TreeNode，如果是，用红黑树的方法取数据，如果不是，走第四步 遍历链表，直到找到相等(==或equals)的 key






