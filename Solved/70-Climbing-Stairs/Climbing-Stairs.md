

# 70. Climbing Stairs

### 题目

链接：https://leetcode.com/problems/climbing-stairs/



### 思路 - Dynamic Programming

#### 步骤

- 状态方程：```dp[i] = dp[i - 1] + dp[i - 2];```


递归这里会超时



#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];   
    }
}
```



##### Python

```python
class Solution:
    def climbStairs(self, n: int) -> int:
        steps = [1, 1]
        for i in range(2, n + 1, 1):
            steps.append(steps[i - 1] + steps[i - 2])
        return steps[n]
    
    def climbStairs2(self, n: int) -> int:
        if n == 0 or n == 1:
            return 1
        dp = [0] * (n + 1)
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n + 1, 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]
```



###### StefanPochmann大佬解法

https://leetcode.com/problems/climbing-stairs/discuss/25296/3-4-short-lines-in-every-language