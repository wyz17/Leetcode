

# 154. Find Minimum in Rotated Sorted Array II

### 题目

链接：https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/



### 思路

#### 步骤

- 二分查找思路
- 中间值 nums[mid] 和右边界值 nums[right] 进行比较：寻找旋转点（最小值）
  - nums[mid] < nums[r]：说明右边有序，丢掉左边，**l = m + 1**，因为m可能是最小值
  - nums[mid] > nums[r]：说明左边有序，最小值一定出现在mid右侧，丢掉右边，**r = m**
  - nums[mid] = nums[r]：说明无法判断，r--（或者将l++，丢弃一个即可），略过一个相同数字，这对结果不会产生影响，因为只是去掉了其中一个相同的



<center class="half">    <img src="https://ewr1.vultrobjects.com/imgspice/000/000/870/658_2b1_9a2.jpg" width="200"/><img src="https://ewr1.vultrobjects.com/imgspice/000/000/870/659_31e_bab.jpg" width="200"/><img src="https://ewr1.vultrobjects.com/imgspice/000/000/870/660_460_f39.jpg" width="200"/> </center>


### 讨论

1. 移动两个指针（l与r）的含义？移动条件是什么（筛选掉一部分数据的依据）？循环的截止条件？

   - left & right：左边界 & 右边界
   - 移动条件：中间值 nums[mid] 和右边界值 nums[right] 进行比较
   - 循环的截止条件：left <= right

2. 数据中是否有重复数字？对结果有什么影响？

   - 有，出现重复数字的情况，我们不能够直接判断mid和r的关系，所以这里先移动一位指针，丢弃一个值就好。因为是重复数字，丢弃一个不影响以后的结果。

3. 为什么你选择的模板中使用left < right 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

   - left <= right：左闭右闭区间
   
4. 在处理逻辑中，当前结果>, <, = 目标值时分别如何处理？移动指针的依据是什么？

   - 指路上方步骤
   
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
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
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
        l, r = 0, len(nums) - 1
        print(r)
        while l <= r:
            m = (r + l) // 2
            if nums[m] > nums[r]:
                l = m + 1
            elif nums[m] < nums[r]:
                r = m
            else:
                r -= 1
        return nums[l]
```

