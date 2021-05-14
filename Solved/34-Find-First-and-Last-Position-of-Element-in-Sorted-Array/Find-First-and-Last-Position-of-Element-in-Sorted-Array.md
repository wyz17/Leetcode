

# 34. Find First and Last Position of Element in Sorted Array

### 题目

链接：https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/



### 思路 - Binary Search

#### 步骤

- 二分查找



### 讨论

1. 移动两个指针（l与r）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？
   - left & right：左边界 & 右边界
   - 移动条件：判断 nums[m] 和 target 的关系，从而修改 l & r
   - 循环的截止条件：l <= r
2. 数据中是否有重复数字？对结果有什么影响？
   - 有，就是寻找重复数字边界
3. 为什么你选择的模板中使用left < right 或者 left <= right 或者 left + 1 < right 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？
   - **left <= right**：左闭右闭区间
4. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？
   - \>：right = mid - 1；mid已被考虑，下一次可以排除
   - \<：left = mid + 1；mid已被考虑，下一次可以排除
   - =：通过while判断target值的边界
5. 循环退出后是否需要额外处理？
   - 无
6. 如果遇到corner case根本没进主循环，你的代码是否能正常工作？
   - nums.length == 0，返回 -1



#### 复杂度

时间：` O(logn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] < target) {
                l = m + 1;
            } else if(nums[m] > target){
                r = m - 1;
            } else {
                l = m;
                r = m;
                while(l - 1 >= 0 && nums[l - 1] == target) l--;
                while(r + 1 <= nums.length - 1 && nums[r + 1] == target) r++;
                res[0] = l;
                res[1] = r;
                return res;
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] < target:
                low = mid + 1
            if nums[mid] > target:
                high = mid - 1
            if nums[mid] == target:
                start = mid
                end = mid
                while start - 1 >= 0 and target == nums[start - 1]:
                    start = start - 1
                while end + 1 <= len(nums) - 1 and target == nums[end + 1]:
                    end = end + 1
                return [start, end]
        return [-1, -1]                
```

