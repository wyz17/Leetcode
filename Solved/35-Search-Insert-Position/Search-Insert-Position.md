

# 35. Search Insert Position

### 题目

链接：https://leetcode.com/problems/search-insert-position/



### 思路

#### 步骤

- 采用二分查找的方法
- easy就很简单啦
- 注意一下边界值的处理



#### 复杂度

时间：` O(logn)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        if(target < nums[0]) return 0;
        if(target > nums[right]) return right + 1;
        
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target)  left = mid + 1;
            if(nums[mid] > target)  right = mid - 1;
        }
        return target < nums[mid] ? mid: mid + 1;
    }
}
```



##### Python

```python
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        if target < nums[0]:
            return 0
        if target > nums[high]:
            return high + 1
        
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                return mid
            if nums[mid] < target:
                low = mid + 1
            if nums[mid] > target:
                high = mid - 1        
        return low
      
  #python里面真的不能乱命名...最开始一直超时，原来是因为left和low都用了...还不报错提示未初始化...晕倒     
```


