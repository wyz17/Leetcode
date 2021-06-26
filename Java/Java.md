# Notes for Java

刷lc时查的内容 & 知识点记录



## Contents

<!--ts-->
   * [Notes for Java](#notes-for-java)
      * [Contents](#contents)
      * [Data Structure](#data-structure)
         * [Queue 队列](#queue-\xE9\x98\x9F\xE5\x88\x97)
         * [Deque 双端队列](#deque-\xE5\x8F\x8C\xE7\xAB\xAF\xE9\x98\x9F\xE5\x88\x97)
         * [Priority Queue 优先队列](#priority-queue-\xE4\xBC\x98\xE5\x85\x88\xE9\x98\x9F\xE5\x88\x97)
         * [HashMap](#hashmap)
         * [Set](#set)
      * [Others](#others)
         * [Arrays.sort()](#arrayssort)
         * [溢出处理](#\xE6\xBA\xA2\xE5\x87\xBA\xE5\xA4\x84\xE7\x90\x86)
         * [判断int整型溢出处理](#\xE5\x88\xA4\xE6\x96\xADint\xE6\x95\xB4\xE5\x9E\x8B\xE6\xBA\xA2\xE5\x87\xBA\xE5\xA4\x84\xE7\x90\x86)
         * [判断字符是否是数字的方法](#\xE5\x88\xA4\xE6\x96\xAD\xE5\xAD\x97\xE7\xAC\xA6\xE6\x98\xAF\xE5\x90\xA6\xE6\x98\xAF\xE6\x95\xB0\xE5\xAD\x97\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [相似问题返回正负的处理方法](#\xE7\x9B\xB8\xE4\xBC\xBC\xE9\x97\xAE\xE9\xA2\x98\xE8\xBF\x94\xE5\x9B\x9E\xE6\xAD\xA3\xE8\xB4\x9F\xE7\x9A\x84\xE5\xA4\x84\xE7\x90\x86\xE6\x96\xB9\xE6\xB3\x95)
         * [一行新建list的方法](#\xE4\xB8\x80\xE8\xA1\x8C\xE6\x96\xB0\xE5\xBB\xBAlist\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [二分查找不要直接用（ low + high）/ 2](#\xE4\xBA\x8C\xE5\x88\x86\xE6\x9F\xA5\xE6\x89\xBE\xE4\xB8\x8D\xE8\xA6\x81\xE7\x9B\xB4\xE6\x8E\xA5\xE7\x94\xA8-low--high-2)
         * [trim() 方法空间复杂度为 O(n)](#trim-\xE6\x96\xB9\xE6\xB3\x95\xE7\xA9\xBA\xE9\x97\xB4\xE5\xA4\x8D\xE6\x9D\x82\xE5\xBA\xA6\xE4\xB8\xBA-on)
         * [处理除法尾数的trick](#\xE5\xA4\x84\xE7\x90\x86\xE9\x99\xA4\xE6\xB3\x95\xE5\xB0\xBE\xE6\x95\xB0\xE7\x9A\x84trick)
         * [判断两个Array是否相等](#\xE5\x88\xA4\xE6\x96\xAD\xE4\xB8\xA4\xE4\xB8\xAAarray\xE6\x98\xAF\xE5\x90\xA6\xE7\x9B\xB8\xE7\xAD\x89)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:24:51 CST 2021 -->

<!--te-->


## Data Structure

### Queue 队列

- **add**    增加一个元素；如果队列已满，则抛出一个IIIegaISlabEepeplian异常
- **remove**  移除并返回队列头部的元素 ，如果队列为空，则抛出一个NoSuchElementException异常
- **element** 返回队列头部的元素；如果队列为空，则抛出一个NoSuchElementException异常
- **offer**    添加一个元素并返回true；如果队列已满，则返回false
- **poll**     移除并返问队列头部的元素；如果队列为空，则返回null
- **peek**    返回队列头部的元素；如果队列为空，则返回null
- **put**     添加一个元素；如果队列满，则阻塞
- **take**    移除并返回队列头部的元素；如果队列为空，则阻塞



### Deque 双端队列

- 普通队列（一端进另一端出）
  - `Queue queue = new LinkedList()`
- 双端队列（两端都可进出）
  - `Deque deque =  new ArrayDeque<>();`
- 堆栈
  - `Deque deque = new LinkedList()`
  - 注意：Java堆栈Stack类已经过时，Java官方推荐使用Deque替代Stack使用。Deque堆栈操作方法：push()、pop()、peek()。

| 第一个元素 (头部) | **最后一个元素 (尾部)** |               |              |              |
| ----------------- | ----------------------- | ------------- | ------------ | ------------ |
|                   | *抛出异常*              | *特殊值*      | *抛出异常*   | *特殊值*     |
| **插入**          | addFirst(e)             | offerFirst(e) | addLast(e)   | offerLast(e) |
| **删除**          | removeFirst()           | pollFirst()   | removeLast() | pollLast()   |
| **检查**          | getFirst()              | peekFirst()   | getLast()    | peekLast()   |

Deque接口扩展（继承）了 Queue 接口。在将双端队列用作队列时，将得到 FIFO（先进先出）行为。将元素添加到双端队列的末尾，从双端队列的开头移除元素。从 Queue 接口继承的方法完全等效于 Deque 方法，如下表所示：

| **Queue方法** | **等效Deque方法** |
| ------------- | ----------------- |
| add add(e)    | addLast(e)        |
| offer(e)      | offerLast(e)      |
| remove()      | removeFirst()     |
| poll()        | pollFirst()       |
| element()     | getFirst()        |
| peek()        | peekFirst()       |

双端队列也可用作 LIFO（后进先出）堆栈。应优先使用此接口而不是遗留 Stack 类。在将双端队列用作堆栈时，元素被推入双端队列的开头并从双端队列开头弹出。堆栈方法完全等效于 Deque 方法，如下表所示：

| **堆栈方法** | **等效Deque方法** |
| ------------ | ----------------- |
| push(e)      | addFirst(e)       |
| pop()        | removeFirst()     |
| peek()       | peekFirst()       |



### Priority Queue 优先队列

- **优先队列的作用是能保证每次取出的元素都是队列中权值最小的**（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）
- Java中*PriorityQueue*实现了*Queue*接口，不允许放入`null`元素
- 其通过堆实现，具体说是通过完全二叉树实现的**小顶堆**（任意一个非叶子节点的权值，都不大于其左右子节点的权值），也就意味着可以通过数组来作为*PriorityQueue*的底层实现。
- **初始化**：```PriorityQueue<Integer> q = new PriorityQueue<Integer>(nums);```
- add()：向优先队列中插入元素，插入失败时抛出异常
- offer()：向优先队列中插入元素，插入失败后则会返回`false`
- element()：获取但不删除队首元素，也就是队列中权值最小的那个元素，当方法失败时前者抛出异常
- peek()：获取但不删除队首元素，也就是队列中权值最小的那个元素，当方法失败时返回`null`
  - 根据小顶堆的性质，堆顶那个元素就是全局最小的那个
  - 由于堆用数组表示，根据下标关系，`0`下标处的那个元素既是堆顶元素
  - 所以**直接返回数组`0`下标处的那个元素即可**
- remove()：获取并删除队首元素，当方法失败时抛出异常
- poll()：获取并删除队首元素，当方法失败时返回`null`
- remove(Object o)：删除队列中跟`o`相等的某一个元素（如果有多个相等，只删除一个）
- reference：https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html





### HashMap

- get()：指定键映射到的值，如果此映射不包含键的映射，则为NULL。
- put()：当存在这个key的时候,会覆盖掉原来的value并返回oldvalue,也就是旧值。
- containsKey(Object key)和containsValue(Object value)



### Set

- set中的数据不存在重复值
- **初始化**：**Set\<Integer> set = new HashSet\<Integer>()**
- **set.contains( x )**：set中是否存在x
- **set.add(x)**：set中添加x
- **set.size()**：set的长度



## Others

### Arrays.sort()

- ```java
  Arrays.sort(int[] a)
  ```

  - 这种形式是对一个数组的所有元素进行排序，并且是按从小到大的顺序
  
- ```java
  Arrays.sort(int[] a, int fromIndex, int toIndex)
  ```

  - 这种形式是对数组部分排序，也就是对数组 a 的下标从 fromIndex 到 toIndex - 1的元素排序，注意：下标为toIndex的元素不参与排序哦
- ```java
  Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
  ```
  - 自定义排序 



### 溢出处理

注意溢出处理校验方式，new_res/10 != old_res时则说明有溢出



### 判断int整型溢出处理

- **if(res >= (Integer.MAX_VALUE / 10))**
- 在这道题中的判断：
  - **if(res > Integer.MAX\_VALUE / 10 || (res == Integer.MAX\_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX\_VALUE % 10))**



### 判断字符是否是数字的方法

- **Character.isDigit('c')**

```java
public class Test {

    public static void main(String args[]) {
        System.out.println(Character.isDigit('c'));
        System.out.println(Character.isDigit('5'));
    }
}
```



### 相似问题返回正负的处理方法

- 可以用一个 **int flg = 1 / -1** 来表示
- 最后的返回值是 **flg * res** 就好（boolean没有int方便）



### 一行新建list的方法

- **Arrays.asList()**


```java
res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
```



### 二分查找不要直接用（ low + high）/ 2

- 用这个

  ```java
  int mid = left + (right - left) / 2;
  ```

- 避免溢出



### trim() 方法空间复杂度为 O(n)

- 删除首尾空格后需建立新字符串，最差情况下占用 O(N) 额外空间



### 处理除法尾数的trick

- ``` java
  res += (num - 1) / k + 1
  ```



### 判断两个Array是否相等

- ```java
  Arrays.equals(window, need)
  ```

