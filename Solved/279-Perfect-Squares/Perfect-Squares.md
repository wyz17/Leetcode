# 279. Perfect Squares

### 题目

- 链接：https://leetcode.com/problems/perfect-squares/
- 题意：返回给出数所包含的最小完全平方数个数之和



### 思路 - Dynamic Programming

#### 步骤

- 使用一位数组dp来存储状态，dp[i]的含义是第i个数所包含的最小完全平方数之和是多少
- 状态方程
  - ``` dp[i] = min(dp[i], dp[i - j * j] + 1)```
  - ```j * j``` 为比i小的最大平方数
  - ```dp[i]``` 可以理解为，有 i 个1的完全平方数



#### 复杂度

时间： `O(N * sqrt(N))`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j < i * i; j++) {
                if(i - j * j < 0) break;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
```



##### Python

```python
class Solution:
    def numSquares(self, n: int) -> int:
        if n == 0: return 0
        dp = [i for i in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, i * i):
                if i - j * j < 0:
                    break
                dp[i] = min(dp[i], dp[i - j * j] + 1)
        return dp[-1]
```

