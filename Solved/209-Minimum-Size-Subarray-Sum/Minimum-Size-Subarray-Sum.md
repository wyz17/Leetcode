# 209. Minimum Size Subarray Sum

### 题目

链接：https://leetcode.com/problems/minimum-size-subarray-sum/



### 思路 - Sliding Window & Two Pointer

#### 步骤

- 利用指针i遍历数组（作为right），求和sum；left作为做指针
- 判断sum是否 >= target，如果是的话，left++同时减少sum，判断是否还满足sum的条件
- 满足条件，更新最小的res即可





#### 复杂度

时间： `O(n)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(left <= i && sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
```



##### Python

```python
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = s = 0
        res = float("inf")
        for i in range(0, len(nums)):
            s += nums[i]
            while left <= i and s >= target:
                res = min(res, i - left + 1)
                s -= nums[left]
                left += 1
        return 0 if res == float("inf") else res
```