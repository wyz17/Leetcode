

# 27. Remove Elements

### 题目

链接：https://leetcode.com/problems/remove-element/



### 思路

#### 步骤

- 傻瓜步骤2号



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Python

```python
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        while val in nums:
            nums.remove(val)
        return len(nums)
```



## Python知识点

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