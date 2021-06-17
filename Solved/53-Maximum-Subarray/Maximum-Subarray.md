

# 53. Maximum Subarray

### 题目

链接：https://leetcode.com/problems/maximum-subarray/



### 思路1 - Dynamic Programming



#### 步骤

- 状态方程：``` dp: max( dp[ i ] ) = getMax( max( dp[ i -1 ] ) + arr[ i ], arr[ i ] )```



#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
```



自己又优化了一下，这里其实不需要dp数组，用int值存就好了，空间复杂度就是` O(1)`：

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if(dp > res) {
                res = dp;
            }
        }
        return res;
    }
}
```



##### 

##### Python

```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        dp[0] = nums[0]
        res = nums[0]
        
        for i in range(1, len(nums)):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
            if dp[i] > res:
                res = dp[i]
        return res
```





### 思路2 - Divide and Conquer 分治法



#### 步骤

- 指路：https://blog.csdn.net/lw_power/article/details/80892362?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control

等有空再补啦



#### 复杂度

时间：` O(？)`

空间：` O(？)`



#### 代码

##### Java

```java

```



##### Python

```python

```

