

# 41. First Missing Positive

### 题目

链接：https://leetcode.com/problems/first-missing-positive/description/



### 思路

#### 步骤

- 因为题目要求时间复杂度为n，空间复杂度为1，所以不能用HashSet这种数据结构

  - 解决方式：利用原数组的空间进行处理

- 我们可以利用数组的index作为值存入

  - ```
    [3,4,-1,1] -> [1,2,3,4] -> 交换后 [1,-1,3,4]
    ```

  - 当num属于 1 至数组长度的时候，就将nums[i]和i + 1交换，直到不满足对应条件的时候再i++

  - 这样遍历一遍数组后，在对应范围内的数都应该是在对应的位置上（i + 1）

  - 后续遍历数组，判断当前i + 1是否等于nums[i]就好，如果不等于就直接返回i + 1

  - 如果数组全都在对应的位置，直接返回数组长度 + 1



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 1;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] <= n && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i + 1 != nums[i]) {
                return i+1;
            };
        }
        return nums.length + 1;
    }
    
    public void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
```



##### Python

```python
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 1
        for i in range(0, len(nums)):
            while nums[i] > 0 and nums[i] <= len(nums) and nums[nums[i] - 1] != nums[i]:
                tmp = nums[i]-1
                nums[i], nums[tmp] = nums[tmp], nums[i]
        
        for i in range(0, len(nums)):
            if nums[i] != i + 1:
                return i + 1
        return len(nums) + 1
```


