# Notes for Python

刷lc时查的内容 & 知识点记录



## Contents

<!--ts-->
   * [Notes for Python](#notes-for-python)
      * [Contents](#contents)
      * [Data Structure](#data-structure)
         * [字典（Dictionary）](#\xE5\xAD\x97\xE5\x85\xB8dictionary)
         * [集合（Set）](#\xE9\x9B\x86\xE5\x90\x88set)
         * [列表（List）](#\xE5\x88\x97\xE8\xA1\xA8list)
            * [操作](#\xE6\x93\x8D\xE4\xBD\x9C)
            * [python中的[1 : ]、[ : : -1]、X[ : , m : n ] 和 X[ 1 , : ]](#python\xE4\xB8\xAD\xE7\x9A\x841------1x---m--n--\xE5\x92\x8C-x-1---)
            * [If判断list是否为空](#if\xE5\x88\xA4\xE6\x96\xADlist\xE6\x98\xAF\xE5\x90\xA6\xE4\xB8\xBA\xE7\xA9\xBA)
         * [Heap（小根堆）](#heap\xE5\xB0\x8F\xE6\xA0\xB9\xE5\xA0\x86)
         * [队列（Queue）](#\xE9\x98\x9F\xE5\x88\x97queue)
         * [双端队列（Deque）](#\xE5\x8F\x8C\xE7\xAB\xAF\xE9\x98\x9F\xE5\x88\x97deque)
      * [Others](#others)
         * [循环](#\xE5\xBE\xAA\xE7\x8E\xAF)
         * [排序](#\xE6\x8E\x92\xE5\xBA\x8F)
         * [collections.Counter()用法](#collectionscounter\xE7\x94\xA8\xE6\xB3\x95)
         * [enumerate() 函数](#enumerate-\xE5\x87\xBD\xE6\x95\xB0)
         * [filter函数](#filter\xE5\x87\xBD\xE6\x95\xB0)
         * [Python字符串拼接方法 &amp; 效率](#python\xE5\xAD\x97\xE7\xAC\xA6\xE4\xB8\xB2\xE6\x8B\xBC\xE6\x8E\xA5\xE6\x96\xB9\xE6\xB3\x95--\xE6\x95\x88\xE7\x8E\x87)
         * [zip函数：用来快速生成映射](#zip\xE5\x87\xBD\xE6\x95\xB0\xE7\x94\xA8\xE6\x9D\xA5\xE5\xBF\xAB\xE9\x80\x9F\xE7\x94\x9F\xE6\x88\x90\xE6\x98\xA0\xE5\xB0\x84)
         * [Python 中 ++ &amp; --](#python-\xE4\xB8\xAD-----)
         * [Python中交换函数一行代码搞定](#python\xE4\xB8\xAD\xE4\xBA\xA4\xE6\x8D\xA2\xE5\x87\xBD\xE6\x95\xB0\xE4\xB8\x80\xE8\xA1\x8C\xE4\xBB\xA3\xE7\xA0\x81\xE6\x90\x9E\xE5\xAE\x9A)
         * [Python中list排序](#python\xE4\xB8\xADlist\xE6\x8E\x92\xE5\xBA\x8F)
         * [Python获取int最大值](#python\xE8\x8E\xB7\xE5\x8F\x96int\xE6\x9C\x80\xE5\xA4\xA7\xE5\x80\xBC)
         * [Python中没有Integer.MAX_VALUE的方法](#python\xE4\xB8\xAD\xE6\xB2\xA1\xE6\x9C\x89integermax_value\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [String取子串的方法](#string\xE5\x8F\x96\xE5\xAD\x90\xE4\xB8\xB2\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [Python三元表达式](#python\xE4\xB8\x89\xE5\x85\x83\xE8\xA1\xA8\xE8\xBE\xBE\xE5\xBC\x8F)
         * [Python 和 java对应逻辑运算符](#python-\xE5\x92\x8C-java\xE5\xAF\xB9\xE5\xBA\x94\xE9\x80\xBB\xE8\xBE\x91\xE8\xBF\x90\xE7\xAE\x97\xE7\xAC\xA6)
         * [Python位运算](#python\xE4\xBD\x8D\xE8\xBF\x90\xE7\xAE\x97)
         * [Python除法](#python\xE9\x99\xA4\xE6\xB3\x95)
         * [Python Tips](#python-tips)
         * [Python isalnum()方法](#python-isalnum\xE6\x96\xB9\xE6\xB3\x95)

<!-- Added by: weiyizhi, at: Thu Jun 24 20:24:52 CST 2021 -->

<!--te-->

## Data Structure

### 字典（Dictionary）

- 格式：`d = {key1 : value1, key2 : value2 }`
- 键一般是唯一的，如果重复最后的一个键值对会替换前面的，值不需要唯一
- 值可以取任何数据类型，但键必须是不可变的，如字符串，数字或元组

```python
dict = {'Alice': '2341', 'Beth': '9102', 'Cecil': '3258'}

dict1 = { 'abc': 456 }
dict2 = { 'abc': 123, 98.6: 37 }
```

```python
dict = {'Name': 'Zara', 'Age': 7, 'Class': 'First'}
print "dict['Name']: ", dict['Name']
print "dict['Age']: ", dict['Age']

#输出结果：
dict['Name']:  Zara
dict['Age']:  7
```

```python
#修改字典
dict['Age'] = 8 # 更新

#删除字典元素
del dict['Name']  # 删除键是'Name'的条目
dict.clear()      # 清空字典所有条目
del dict          # 删除字典
```

补充链接：https://www.runoob.com/python/python-dictionary.html



### 集合（Set）

- 集合中不可以出现重复的元素
- 初始化
  - 创建一个空集合必须用 **set()** 而不是 **{ }**，因为 **{ }** 是用来创建一个空字典。
  - ``` s = set()```
- 添加元素
  - ``` s.update( x )```
  - 将元素 x 添加到集合 s 中，如果元素已存在，则不进行任何操作。
- 移除元素
  - ``` s.remove( x )```
  - 将元素 x 从集合 s 中移除，如果元素不存在，则会发生错误。
- 清空集合
  - ``` s.clear( x )```



### 列表（List）

#### 操作

- 删除操作
  
  - del：根据索引删除元素
    - `del listname[index]`
    - `del listname[start : end]`：删除中间一段连续的元素
  - pop()：根据索引删除元素
    - `listname.pop(index)`
    - listname 表示列表名称，index 表示索引值。如果不写 index 参数，默认会删除列表中的最后一个元素
  - remove()：根据元素值删除元素
    - remove() 方法只会删除第一个和指定值相同的元素，而且必须保证该元素是存在的，否则会引发 ValueError 错误
  - clear()：删除列表所有元素
  
- 添加操作

  - append()

  - extend()

    - ```
      list.extend(seq)
      ```
      
    - extend() 函数用于在列表末尾一次性追加另一个序列中的多个值（用新列表扩展原来的列表）

  - 加号

    - ``` python
      li = ['a', 'b', 'mpilgrim']
      li = li + ['example', 'new']
      li += ['two']
      ```



#### python中的[1 : ]、[ : : -1]、X[ : , m : n ] 和 X[ 1 , : ]

- **[1 : ]**：意思是去掉列表中第一个元素（下标为0），去后面的元素进行操作
- **[ : : -1]**：a[::-1] 相当于 a[-1:-len(a)-1:-1]，也就是从最后一个元素到第一个元素复制一遍。
- **X[ : , m : n ]**：取所有数据的第m到n-1列数据，含左不含右
- **X[ 1 , : ]**：取所有行的第1个数据
- **X[ -2 ]**：表示倒数第二个index所对应的值



#### If判断list是否为空

```python
list_1 = [1,2]
if list_1:
	print('list_2 is not none')

list_2 = []
if not list_2:
    print('list_2 is none')
```



### Heap（小根堆）

- 初始化

  - 	```python
      heap = []
      for num in nums:
      heapq.heappush(heap, num)  # 加入堆
  - 	```python
  nums = [2, 3, 5, 1, 54, 23, 132]
  heapq.heapify(nums)
  print([heapq.heappop(nums) for _ in range(len(nums))])  # 堆排序结果

- 添加一个元素：```heappush(heap, x)```

- 删除一个元素（从堆中弹出最小的元素）：```heappop(heap)```

- 列表初始化成堆：```heapify(heap)```

- 删除最小的元素，并添加x：```heapreplace(heap, x)```

- 返回堆中n个最大的元素：```nlargest(n, iter)```

- 返回堆中n个最小的元素：```nsmallest(n, iter)```



### 队列（Queue）

- 初始化：``` q = []```
- 添加一个元素：``` d.append()```
- 弹出一个元素：``` d.pop()```
- 计算队列元素数：```len(q)```
- 获取元素首尾
  - 获取队列首部第一个数：```q[0]```
  - 获取队列尾部第一个数：```q[-1]```



### 双端队列（Deque）

- 初始化：``` d = deque()```
- 首部
  - 添加一个元素：``` d.appendleft()```
  - 弹出一个元素：``` d.popleft()```
- 尾部
  - 添加一个元素：``` d.append()```
  - 弹出一个元素：``` d.pop()```
- 计算队列元素数：```d.count()```
- 获取元素首尾
  - 获取队列首部第一个数：```d[0]```
  - 获取队列尾部第一个数：```d[-1]```



## Others

### 循环

- **for i in range 循环**
  - Python中for i in range循环中的i值是不可以在循环中改变的
  - 每一次语句都会给i值重新赋值
  - 如果要在循环的过程中更改i的值（step），最好用while循环去做
- **for i in reversed(range(1, 10, 2))**
  - 逆序循环



### 排序

- sorted()：内置函数sorted()会新建一个列表从作为返回值，这个方法可以接受任何形式的可迭代对象作为参数，甚至包括不可变序列或者生成器

  - ```python
    sorted([36, 5, -12, 9, -21], key=abs)
    sorted(['bob', 'about', 'Zoo', 'Credit'], key=str.lower, reverse=True)
    ```

- .sort()：list.sort方法会就地排序列表，不会把原列表复制一份，这也就是这个方法返回值是None的原因，提醒本方法不会新建列表

  - ```python
    sorted(fruits, reverse=True)
    sorted(fruits, key=len, reverse=True)
    ```




### collections.Counter()用法

我们先看一个简单的例子：

```python
#统计词频
colors = ['red', 'blue', 'red', 'green', 'blue', 'blue']
result = {}
for color in colors:
    if result.get(color)==None:
        result[color]=1
    else:
        result[color]+=1
print (result)
#{'red': 2, 'blue': 3, 'green': 1}
```

下面我们看用Counter怎么实现：

```python
from collections import Counter
colors = ['red', 'blue', 'red', 'green', 'blue', 'blue']
c = Counter(colors)
print (dict(c))
```



可以创建一个空的Counter：

```python
cnt = Counter()
```

之后在空的Counter上进行一些操作。
也可以创建的时候传进去一个迭代器（数组，字符串，字典等）：

```python
c = Counter('gallahad')                 # 传进字符串
c = Counter({'red': 4, 'blue': 2})      # 传进字典
c = Counter(cats=4, dogs=8)             # 传进元组
```

判断是否包含某元素，可以转化为dict然后通过dict判断，Counter也带有函数可以判断：

```python
c = Counter(['eggs', 'ham'])
c['bacon']                              # 不存在就返回0
#0
```

删除元素：

```python
c['sausage'] = 0                        # counter entry with a zero count
del c['sausage']   
```

获得所有元素：

```python
c = Counter(a=4, b=2, c=0, d=-2)
list(c.elements())
#['a', 'a', 'a', 'a', 'b', 'b']
```

查看最常见出现的k个元素：

```python
Counter('abracadabra').most_common(3)
#[('a', 5), ('r', 2), ('b', 2)]
```

Counter更新：

```python
c = Counter(a=3, b=1)
d = Counter(a=1, b=2)
c + d                       # 相加
#Counter({'a': 4, 'b': 3})
c - d                       # 相减，如果小于等于0，删去
#Counter({'a': 2})
c & d                       # 求最小
#Counter({'a': 1, 'b': 1})
c | d                       # 求最大
#Counter({'a': 3, 'b': 2})
```



### enumerate() 函数

- **enumerate(sequence, [start = 0])**
- sequence -- 一个序列、迭代器或其他支持迭代对象
- start -- 下标起始位置

```python
>>> seasons = ['Spring', 'Summer', 'Fall', 'Winter']
>>> list(enumerate(seasons))
[(0, 'Spring'), (1, 'Summer'), (2, 'Fall'), (3, 'Winter')]
>>> list(enumerate(seasons, start=1))       # 下标从 1 开始
[(1, 'Spring'), (2, 'Summer'), (3, 'Fall'), (4, 'Winter')]
```

```python
>>>seq = ['one', 'two', 'three']
>>> for i, element in enumerate(seq):
...     print i, element
... 
0 one
1 two
2 three
```



### filter函数

- **filter()** 函数用于过滤序列，过滤掉不符合条件的元素，返回由符合条件元素组成的新列表。
- 该接收两个参数，第一个为函数，第二个为序列，序列的每个元素作为参数传递给函数进行判断，然后返回 True 或 False，最后将返回 True 的元素放到新列表中。
- eg：https://www.runoob.com/python/python-func-filter.html



### Python字符串拼接方法 & 效率

- 直接通过加号(+)操作符连接
	- ```python
    website = 'python' + 'tab' + '.com'
    ```
	- 使用简单直接，但效率低，因为python中字符串是不可变的类型，使用 + 连接两个字符串时会生成一个新的字符串，生成新的字符串就需要重新申请内存，当连续相加的字符串很多时(a+b+c+d+e+f+...) ，效率低下就是必然的了


- join方法
	- ```python
    listStr =  ['python', 'tab', '.com'] 
    website = ''.join(listStr)
	  ```
	- 使用略复杂，但对多个字符进行连接时效率高，只会有一次内存的申请。而且如果是对list的字符进行连接的时候，这种方法必须是首选

- **替换**（pick这个！）
	
  - ```python
	  website = '%s%s%s' % ('python', 'tab', '.com')
	  ```
	- 字符串格式化，这种方法非常用



### zip函数：用来快速生成映射

- 接受任意多个（包括0个和1个）序列作为参数，返回一个tuple列表

- ```python
  x = [1, 2, 3]
  y = [4, 5, 6, 7]
  xy = zip(x, y)
  print xy
  ```
- 运行的结果是：

  [(1, 4), (2, 5), (3, 6)]



### Python 中 ++ & --

- python中没有这个，实现自增只能 a = a + 1 或 a += 1
  - python中的数字类型是不可变数据，也就是数字类型数据在内存中不会发生改变，当变量值发生改变时，会新申请一块内存赋值为新值，然后将变量指向新的内存地址
    - += 是改变变量，相当于重新生成一个变量，把操作后的结果赋予这个新生成的变量
    - -- 是改变了对象本身，而不是变量本身，即改变数据地址所指向的内存中的内容



### Python中交换函数一行代码搞定

- Python以引用方式管理对象，你可以交换引用，但通常不能交换内存中的对象值
  - ```python
    def swap(t1, t2):
        t2, t1 = t1, t2
        return
    ```

- 交换数组值的例子

  - ```python
    def swap(self, nums, i, j):
        nums[i], nums[j] = nums[j], nums[i]
        return nums
    ```

    

### Python中list排序

```python
list.sort(cmp=None, key=None, reverse=False)
```

- key -- 主要是用来进行比较的元素，只有一个参数，具体的函数的参数就是取自于可迭代对象中，指定可迭代对象中的一个元素来进行排序。
- reverse -- 排序规则，**reverse = True** 降序， **reverse = False** 升序（默认）。



### Python获取int最大值

``````python
import sys
MAX_INT = sys.maxsize
print(MAX_INT)
``````



### Python中没有Integer.MAX_VALUE的方法

- 替换参考：正负无穷

  - ```python
    float("inf"), float("-inf")
    ```







### String取子串的方法

```
str = ’0123456789′
print str[0:3] #截取第一位到第三位的字符
print str[:] #截取字符串的全部字符
print str[6:] #截取第七个字符到结尾
print str[:-3] #截取从头开始到倒数第三个字符之前
print str[2] #截取第三个字符
print str[-1] #截取倒数第一个字符
print str[::-1] #创造一个与原字符串顺序相反的字符串
print str[-3:-1] #截取倒数第三位与倒数第一位之前的字符
print str[-3:] #截取倒数第三位到结尾
print str[:-5:-3] #逆序截取，具体啥意思没搞明白？
```

- Python中没有charAt的方法：使用的话直接string[i]就好



### Python三元表达式

三元表达式

res='zuo' if x > y else 'you'

如果条件成立返回zuo 不成立返回you 中间是条件判断这就是三元表达式

```python
 return res if flg == True else 0 - res
```





### Python 和 java对应逻辑运算符

- && ： and
- || ：or
- ！：not

Python中没有null

- 替代：None



### Python位运算

| &    | 按位与运算符：参与运算的两个值,如果两个相应位都为1,则该位的结果为1,否则为0 | (a & b) 输出结果 12 ，二进制解释： 0000 1100                 |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| \|   | 按位或运算符：只要对应的二个二进位有一个为1时，结果位就为1。 | (a \| b) 输出结果 61 ，二进制解释： 0011 1101                |
| ^    | 按位异或运算符：当两对应的二进位相异时，结果为1              | (a ^ b) 输出结果 49 ，二进制解释： 0011 0001                 |
| ~    | 按位取反运算符：对数据的每个二进制位取反,即把1变为0,把0变为1 。**~x** 类似于 **-x-1** | (~a ) 输出结果 -61 ，二进制解释： 1100 0011，在一个有符号二进制数的补码形式。 |
| <<   | 左移动运算符：运算数的各二进位全部左移若干位，由 **<<** 右边的数字指定了移动的位数，高位丢弃，低位补0。 | a << 2 输出结果 240 ，二进制解释： 1111 0000                 |
| >>   | 右移动运算符：把">>"左边的运算数的各二进位全部右移若干位，**>>** 右边的数字指定了移动的位数 | a >> 2 输出结果 15 ，二进制解释： 0000 1111                  |



### Python除法

- Python 2.2
  - 要引用： from __future__ import division
  - " / "就表示 浮点数除法，返回浮点结果
  - " // "表示整数除法。

- Python 3以后：
  - " / "就表示 浮点数除法，返回浮点结果
  - " // "表示整数除法。



### Python Tips

- def方法一定要定义在使用前（与java不同）

- python数据结构中带索引的集合可以使用dict（替换java中的map）

- 自己调用自己的时候记得加self.xxx

  - 定义的时候也要加上self！

  - sample参考：

  - ```python
    class Solution:
        def nextPermutation(self, nums: List[int]) -> None:
            self.reverse(nums, i)
        
        def reverse(self, nums, start):
            i = start
            j = len(nums) - 1
            while i <= j:
                swap(nums, i, j)
                i = i + 1
                j = j - 1
            return nums
                
    ```




### Python isalnum()方法

- Python isalnum() 方法检测字符串是否由字母和数字组成

- ```python
  str.isalnum()
  ```

