

# 32. 32-Search in Rotated Sorted Array

### 题目

链接：https://leetcode.com/problems/search-in-rotated-sorted-array/



### 思路 - Binary Search

#### 步骤

- 采用二分查找的方法
- 主要思路就是判断mid会落入哪个区间，认真分析就好啦



#### 复杂度

时间：` O(logn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        
        if(nums.length == 0 || nums == null) {
            return -1;
        }
        
        if(nums.length == 1) {
            if(nums[0] == target){
                return 0;
            }
            else{
                return -1;
            }
        }
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < nums[right]) {
                //mid is in the right side
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
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
        if len(nums) == 0 or nums == None:
            return -1
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
        
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            if nums[mid] < nums[right]:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[mid] > target and target >= nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1
        return -1
```


