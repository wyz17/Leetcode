# Notes for Python

刷lc时查的内容 & 知识点记录



## Contents

<!--ts-->
   * [Notes for Python](#notes-for-python)
      * [Contents](#contents)
      * [Data Structure](#data-structure)
         * [字典（Dictionary）](#\xE5\xAD\x97\xE5\x85\xB8dictionary)
      * [Others](#others)
         * [enumerate() 函数](#enumerate-\xE5\x87\xBD\xE6\x95\xB0)
         * [zip函数：用来快速生成映射](#zip\xE5\x87\xBD\xE6\x95\xB0\xE7\x94\xA8\xE6\x9D\xA5\xE5\xBF\xAB\xE9\x80\x9F\xE7\x94\x9F\xE6\x88\x90\xE6\x98\xA0\xE5\xB0\x84)
         * [Python 中 ++ &amp; --](#python-\xE4\xB8\xAD-----)
         * [Python中list排序](#python\xE4\xB8\xADlist\xE6\x8E\x92\xE5\xBA\x8F)
         * [Python获取int最大值](#python\xE8\x8E\xB7\xE5\x8F\x96int\xE6\x9C\x80\xE5\xA4\xA7\xE5\x80\xBC)
         * [List删除元素的方法](#list\xE5\x88\xA0\xE9\x99\xA4\xE5\x85\x83\xE7\xB4\xA0\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [String取子串的方法](#string\xE5\x8F\x96\xE5\xAD\x90\xE4\xB8\xB2\xE7\x9A\x84\xE6\x96\xB9\xE6\xB3\x95)
         * [Python三元表达式](#python\xE4\xB8\x89\xE5\x85\x83\xE8\xA1\xA8\xE8\xBE\xBE\xE5\xBC\x8F)
         * [Python 和 java对应逻辑运算符](#python-\xE5\x92\x8C-java\xE5\xAF\xB9\xE5\xBA\x94\xE9\x80\xBB\xE8\xBE\x91\xE8\xBF\x90\xE7\xAE\x97\xE7\xAC\xA6)
         * [Python replace Java](#python-replace-java)
         * [Python Tips](#python-tips)

<!-- Added by: weiyizhi, at: 2020年12月12日 星期六 16时20分22秒 CST -->

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



## Others

### enumerate() 函数

- **enumerate(sequence, [start = 0])**
- sequence -- 一个序列、迭代器或其他支持迭代对象
- start -- 下标起始位置

```python
>>>seasons = ['Spring', 'Summer', 'Fall', 'Winter']
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



### List删除元素的方法

- del：根据索引删除元素
  - `del listname[index]`
  - `del listname[start : end]`：删除中间一段连续的元素
- pop()：根据索引删除元素
  - `listname.pop(index)`
  - listname 表示列表名称，index 表示索引值。如果不写 index 参数，默认会删除列表中的最后一个元素
- remove()：根据元素值删除元素
  - remove() 方法只会删除第一个和指定值相同的元素，而且必须保证该元素是存在的，否则会引发 ValueError 错误
- clear()：删除列表所有元素



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



### Python replace Java

- def方法一定要定义在使用前（与java不同）
- python数据结构中带索引的集合可以使用dict（替换java中的map）



### Python Tips

- 自己调用自己的时候记得加self.xxx
