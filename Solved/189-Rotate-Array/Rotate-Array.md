

# 189. Rotate Array

### 题目

链接：https://leetcode.com/problems/rotate-array/



### 思路1 - Reverse

#### 步骤

- ```
  Original List                   : 1 2 3 4 5 6 7
  After reversing all numbers     : 7 6 5 4 3 2 1
  After reversing first k numbers : 5 6 7 4 3 2 1
  After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
  ```

- 一共要reverse三次
  - 第一次反转：反转全部的数组
  - 第二次反转：反转前面 0 ～ k - 1 的数字
  - 第三次反转：反转后面 k ～ nums长度的数字
- 注意当k大于数组长度的情况！
  - ```  k %= nums.length;```



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, nums.length - 1);        
    }
    
    public int[] reverse(int[] nums, int start, int end) {
        while(end >= start) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        return nums;
    }
}
```



##### Python

```python
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        nums = self.reverse(nums, 0, len(nums) - 1)
        nums = self.reverse(nums, 0, k - 1)
        nums = self.reverse(nums, k, len(nums) - 1)
        
    
    def reverse(self, nums, start, end):
        while end >= start:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
        return nums
```



##### JavaScript

```javascript
var rotate = function(nums, k) {
   k %= nums.length;
   let reverse = function(i, j){
    while(i < j){
        let temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
        i++
        j--
    }
   };
    reverse(0, nums.length-1);
    reverse(0, k-1);
    reverse(k, nums.length-1);
};
```



### 思路2 - Extra Space

#### 步骤

- 利用新的array去存储
- 注意区分array的引用！



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
```



##### Python

```python
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        arr = [0] * len(nums)
        for i in range(0, len(nums)):
            arr[(i + k) % len(nums)] = nums[i] 
        for j in range(0, len(nums)):
            nums[j] = arr[j]
```

