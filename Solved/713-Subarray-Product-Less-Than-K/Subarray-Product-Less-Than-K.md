# 713. Subarray Product Less Than K

### 题目

链接：https://leetcode.com/problems/subarray-product-less-than-k/



### 思路 - Sliding Window

- 利用指针i遍历数组（作为right），求和sum；left作为做指针
- 判断product是否 >= target，如果是的话，left++同时减少target，判断是否还满足target的条件
- 满足条件，res增加即可



### 复杂度

时间：```O(n)```

空间：```O(1)```



### 代码

#### Java

```java
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int left = 0, res = 0, product = 1;
        for(int right = 0; right < nums.length; right++){
            product *= nums[right];
            while(product >= k) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
```



#### Python

```python
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        res = left = 0
        product = 1
        for right in range(0, len(nums)):
            product *= nums[right]
            while product >= k:
                product /= nums[left]
                left += 1
            res += right - left + 1
        return res
```



