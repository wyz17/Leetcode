# 1283. Find the Smallest Divisor Given a Threshold

### 题目

链接：https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/



### 思路

#### 步骤

- 二分查找思路
- 指针移动条件：判断当前为mid的值的时候，divisor是否小于threshold





#### 复杂度

时间： `O(mlogn)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1000000;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(getDivisor(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    private int getDivisor(int[] nums, int divisor) {
        int res = 0;
        for(int n: nums) {
            res += (n - 1) / divisor + 1;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        left, right = 1, 1000000
        while left <= right:
            mid = (left + right) // 2
            if self.getDivided(nums, mid) > threshold:
                left = mid + 1
            else:
                right = mid - 1
        return left
        
    def getDivided(self, nums, divisor):
        res = 0
        for num in nums:
            res += (num - 1) // divisor + 1
        return res
```

