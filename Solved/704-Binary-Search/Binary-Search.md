

# 704. Binary Search

### 题目

链接：https://leetcode.com/problems/binary-search/



### 思路

#### 步骤

- 二分查找思路



### 讨论

1. 移动两个指针（l与r）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？

   - left & right：左边界 & 右边界
   - 移动条件：判断m和target的关系，从而修改 left & right
   - 循环的截止条件：mid == target

2. 数据中是否有重复数字？对结果有什么影响？

   - 无重复数字

3. 为什么你选择的模板中使用left < right 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

   - 初始化 right 的赋值是 nums.length-1，即最后一个元素的索引，而不是 nums.length，所以是**左闭右闭区间**
   - 死循环情况：存在start == end == target的情况，如果不是小于等于的话就会返回 -1

4. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？

   - 由于题目只返回index并且无重复值，所以就可以简单使用 + 1 & - 1

   - \>：right = mid - 1；mid已被考虑，下一次可以排除
   - \<：left = mid + 1；mid已被考虑，下一次可以排除
   - =：return mid
   - 指针移动依据：判断m和target的关系，从而修改 left & right

5. 循环退出后是否需要额外处理？

   - 返回 -1

6. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？

   - 题目规定nums.length > 1，done



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + ((r - l) / 2);
            if(nums[m] > target) {
                r = m - 1;
            }
            else if(nums[m] < target) {
                l = m + 1;
            }
            else {
                return m;
            }
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if nums[m] > target: r = m - 1
            elif nums[m] < target: l = m + 1
            else: return m
        return -1
```

