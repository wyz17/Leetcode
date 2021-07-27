# 442. Find All Duplicates in an Array

### 题目

- 链接：https://leetcode.com/problems/find-all-duplicates-in-an-array/
- 题意
  - 返回给出数组中，只出现两次的数
  - 要求**time complexity O(n) & space complexity constant**



### 思路

#### 步骤

- 因为空间要求常数，所以不适使用新的数组作为空间
- 遍历数组，当遇到数字i时，将index为i-1的数反转为负数
- 如果nums[i-1]已经是负数了，说明当前数字已经出现两次，添加到res就好
- 前提：数组中数字只出现1或2次；数字范围是```[1, n]```



#### 复杂度

时间： `O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) {
                res.add(Math.abs(idx + 1));
            }
            nums[idx] = -nums[idx];
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        for idx, num in enumerate(nums):
            index = abs(nums[idx]) - 1
            if nums[index] < 0:
                res.append(index + 1)
            nums[index] = -nums[index]
        return res
```