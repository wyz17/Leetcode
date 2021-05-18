

# 278. First Bad Version

### 题目

链接：https://leetcode.com/problems/first-bad-version/



### 思路

#### 步骤

- 二分查找思路
- 判断中间值 nums[mid]是否为true
  - nums[mid] == true：说明firstBadVersion在左边，**r = m**
  - nums[mid] == false：说明firstBadVersion在右边，**l = m + 1**




### 讨论

1. 移动两个指针（l与r）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？

   - left & right：左边界 & 右边界
   - 移动条件：判断中间值 nums[mid]是否为true
   
2. 数据中是否有重复数字？对结果有什么影响？

   - 无

3. 为什么你选择的模板中使用left < right 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

   - left < right：左闭右开区间
   - 如果是 <= 的话，当 l == r == m的时候会出现死循环
   
4. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？

   - 指路上方步骤
   
5. 循环退出后是否需要额外处理？

   - 返回 nums[left]

6. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？

   - 题目规定bad >= 1，done



#### 复杂度

时间： `O(logn)`

空间：` O(1)`

#### 代码

##### Java

```java
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(isBadVersion(m)) r = m;
            else l = m + 1;
        }
        return l;
    }
}


// interesting
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(isBadVersion(m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
}
```



##### Python

```python
class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        l, r = 1, n
        while l < r:
            m = (l + r) // 2
            if isBadVersion(m):
                r = m
            else:
                l = m + 1
        return l
```