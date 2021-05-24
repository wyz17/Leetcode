# 283. Move Zeroes

### 题目

链接：https://leetcode.com/problems/move-zeroes/



### 思路

#### 步骤

- 使用两个指针 i, j
- 指针i：记录数组非0的index
- 指针j：记录数组为0的index
- 遍历循环并将nums[i], nums[j]交换



#### 复杂度

时间： `O(n)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                if(j!=i)
                    nums[i] = 0;
                j++;
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i, j = 0, 0
        for num in nums:
            if num == 0:
                j += 1
            else:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j += 1
        return nums
```


