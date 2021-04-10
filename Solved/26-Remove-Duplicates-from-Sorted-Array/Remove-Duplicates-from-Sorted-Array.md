

# 26. Remove Duplicates from Sorted Array

### 题目

链接：https://leetcode.com/problems/remove-duplicates-from-sorted-array/



### 思路

#### 步骤

- 傻瓜步骤



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num : nums) {
            if(i < 1 || nums[i - 1] < num)
                nums[i++] = num;
        }
        return i;
    }
}
```



##### Python

```python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i=0
        while i+1 < len(nums):
            if nums[i] == nums[i+1]:
                nums.pop(i)
            else:
                i=i+1
        return len(nums)
```



##### JavaScript

```javascript
var removeDuplicates = function(nums) {
    let i = 0;
    for (let j = 0; j < nums.length; j++) {
        if (nums[j] != nums[i]) 
            nums[++i] = nums[j];
    }
    return ++i;
};
```

