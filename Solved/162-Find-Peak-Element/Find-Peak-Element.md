# 162. Find Peak Element

### 题目

链接：https://leetcode.com/problems/find-peak-element/



### 思路

#### 步骤

- 二分查找思路
- 指针移动条件：比较nums[mid]和nums[mid + 1]

- 数据中是否有重复数字？对结果有什么影响？

  - 题目规定没有连续的重复数字

- 为什么你选择的模板中使用start < end 或者 start <= end 或者 start + 1 < end 作为终止条件？这样写是如何避免死循环的？不这么写在什么情况下会出现死循环？

  -  选择left < right，如果相等的话，比较mid+1的时候会出现数组越界




#### 复杂度

时间： `O(logn)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
```



##### Python

```python
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                right = mid
        return left
```