

# 81. Search in Rotated Sorted Array II    

### 题目

链接：https://leetcode.com/problems/search-in-rotated-sorted-array-ii/



### 思路 - Binary Search

#### 步骤

- 注意 mid 与 l / r重复情况的判断
- 注意判断的边界值



#### 复杂度

时间：` O(NlogN)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(target == nums[mid]) {
                return true;
            }
            if(nums[mid] < nums[r] || nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            else if(nums[mid] > nums[l] || nums[mid] > nums[r]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            else {
                r--;
            }
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        l = 0
        r = len(nums) - 1
        
        while l <= r:
            mid = l + (r - l) // 2
            if target == nums[mid]:
                return True
            while l < mid and nums[l] == nums[mid]:
                l += 1
            if nums[mid] < nums[r] or nums[mid] < nums[l]:
                if target > nums[mid] and target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                if target < nums[mid] and target >= nums[l]:
                    r = mid - 1
                else:
                    l = mid + 1
                
        return False
```


