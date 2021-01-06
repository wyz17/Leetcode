

# 62. Unique Paths

### 题目

链接：https://leetcode.com/problems/unique-paths/



### 思路1 - Dynamic Programming

#### 步骤

- dp一下
- 状态方程：```dp[i][j] = dp[i - 1][j] + dp[i][j - 1];```
- 意思是每一步的当前path是自己左边 + 上面 path之和



#### 复杂度

时间：` O(M * N)`

空间：` O(M * N)` &  ` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int j = 0; j < n; j++)
            dp[0][j] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```



##### Python

```python
class Solution:
    # O(n) space 
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return 0
        dp = [1] * n 
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[-1]    
    
    # O(m*n) space   
    def uniquePaths1(self, m: int, n: int) -> int:
        if not m or not n:
            return 0
        dp = [[1 for i in range(0, n)] for j in range(0, m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]
```



### 思路2 - 数学组合

#### 步骤

- 这个问题的实质上是一个C的组合问题
- 机器人总共走m+n-2步，其中m-1步往下走，n-1步往右走，本质上就是一个组合问题，也就是从m+n-2个不同元素中每次取出m-1个元素的组合数
- [组合参考](https://zh.wikipedia.org/wiki/組合#理論與公式)



#### 复杂度

时间：` O(min(M,N))`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public int uniquePaths(int m, int n) {
    double dom = 1;
    double dedom = 1;
    int small = m < n ? m-1 : n-1;
    int big = m < n? n-1 : m-1;
    for(int i = 1; i <= small; i++){
        dedom *= i;
        dom *= small + big + 1 - i;
    }
    return (int)(dom/dedom);
    }
}
```



##### Python

```python
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return 0
        return int(math.factorial(m+n-2) / (math.factorial(n-1) * math.factorial(m-1)))
```