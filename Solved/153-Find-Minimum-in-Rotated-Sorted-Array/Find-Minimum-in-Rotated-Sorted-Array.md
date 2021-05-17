

# 153. Find Minimum in Rotated Sorted Array

### 题目

链接：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/



### 思路

#### 步骤

- 二分查找思路
- 中间值 nums[mid] 和右边界值 nums[right] 进行比较：寻找旋转点（最小值）
  - 若数组没有旋转或者旋转点在左半段的时候，中间值是一定小于右边界值的，所以要去左半边继续搜索
  - 反之则去右半段查找，最终返回 nums[right] 即可



### 讨论

1. 移动两个指针（l与r）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？

   - left & right：左边界 & 右边界
   - 移动条件：
   - 循环的截止条件：left <= right

2. 数据中是否有重复数字？对结果有什么影响？

   - 无重复数字

3. 为什么你选择的模板中使用left < right 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

   - left <= right：左闭右闭区间
   
4. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？

   - \>：right = mid - 1；mid已被考虑，下一次可以排除
   - \<：left = mid + 1；mid已被考虑，下一次可以排除
   - =：return mid
   - 指针移动依据：判断m和 nums[right]的关系，从而修改 left & right

5. 循环退出后是否需要额外处理？

   - 返回 nums[left]

6. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？

   - 题目规定nums.length > 1，done



#### 复杂度

时间： `O(nlogn)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length - 1;
        int l = 0, r = len;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] > nums[len]) {
                l = m + 1;
            } else if (nums[m] < nums[len]) {
                r = m - 1;
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }
}
```



##### Python

```python
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums) - 1
        l, r = 0, n
        while l <= r:
            m = (l + r) // 2
            if nums[m] < nums[n]:
                r = m - 1
            elif nums[m] > nums[n]:
                l = m + 1
            else:
                return nums[m]
        return nums[l]
```