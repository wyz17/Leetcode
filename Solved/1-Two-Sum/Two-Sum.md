# 1. Two Sum

### 题目

链接：https://leetcode.com/problems/two-sum/





### 思路1 - 暴力解法

#### 步骤

- 双重循环遍历



#### 复杂度

时间：```O(n^2)```

空间：```O(1)```



#### 代码

##### Python

``` python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res = []
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    res.append(i)
                    res.append(j)
        return res
```



### 思路2 - 构造字典

#### 步骤

- 构造一个字典
- 字典用来存储当前元素完成target需要的元素值作为key，当前元素的index作为value。
- 然后遍历过程中进行判断，当前元素是不是属于我想要的元素，是的话，直接输出 [字典中该元素的下标,当前遍历元素下标]



#### 复杂度

时间：```O(n)```

空间：```O(n)```

从时间复杂度的角度来看，第一层for循环是O(n)，字典采用的是hash函数的结构，所以在 x in dict的查找过程中，时间复杂度为O(1)，而这里没用到index查询，而是直接获取value值，而字典的Get Item的复杂度也是O(1)，所以整个算法的时间复杂度为O(n)，不过这里的空间复杂度是O(n)，用空间换时间



#### 代码

##### Python

``` python
class Solution(object):
    def twoSum(self, nums, target):
        res = {}
        for i, num in enumerate(nums):
            if num in res:
                return [i, res[num]]
            else:
                res[target - num] = i
```





# Python知识点

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



### **字典（Dictionary）**

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









