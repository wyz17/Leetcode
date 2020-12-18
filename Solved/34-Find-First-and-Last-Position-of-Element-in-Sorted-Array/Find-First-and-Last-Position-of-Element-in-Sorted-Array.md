

# 34. Find First and Last Position of Element in Sorted Array

### 题目

链接：https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/



### 思路 - Binary Search

#### 步骤

- 采用二分查找的方法
- 用while判断target == mid时候的范围就好



#### 复杂度

时间：` O(logn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] err = {-1,-1};
        if(nums.length == 0)
            return err;
        if(target < nums[left] || target > nums[right])
            return err;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid;
                right = mid;
                while(left - 1 >= 0 && nums[left - 1] == target)
                    left--;
                while(right + 1 < nums.length && nums[right + 1] == target)
                    right++;
                break;
            }
            if(nums[mid] < target)
                left = mid + 1;
            if(nums[mid] > target)
                right = mid - 1;
        }
        int[] res = {left, right};
        if(nums[left] != target || nums[right] != target)
            return err;
        return res;
    }
}
```



##### Python

```python
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) 
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] < target:
                low = mid + 1
            if nums[mid] > target:
                #!
                high = mid
            if nums[mid] == target:
                start = mid
                end = mid
                while start >= 1 and target == nums[start - 1]:
                    start = start - 1
                while end < len(nums) - 1 and target == nums[end + 1]:
                    end = end + 1
                return [start, end]
        return [-1, -1]
                
```


