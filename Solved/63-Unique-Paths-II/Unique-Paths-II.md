

# 63. Unique Paths II

### 题目

链接：https://leetcode.com/problems/unique-paths-ii/



### 思路 - Dynamic Programming

#### 步骤

- dp一下：和前一题 [Unique Paths](Solved/62-Unique-Paths/Unique-Paths.md) 的思路一样
- 状态方程：```dp[i][j] = dp[i - 1][j] + dp[i][j - 1];```
- 意思是每一步的当前path是自己左边 + 上面 path之和
- 



#### 复杂度

时间：` O(M * N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for(int i = 1; i < m; i++)
            obstacleGrid[i][0] = (obstacleGrid[i][0] != 1 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        for(int j = 1; j < n; j++)
            obstacleGrid[0][j] = (obstacleGrid[0][j] != 1 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] != 1 ? obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1] : 0;
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
```



##### Python

```python
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if not obstacleGrid:
            return
        m, n = len(obstacleGrid), len(obstacleGrid[0]);
        obstacleGrid[0][0] = 1 - obstacleGrid[0][0]
        for i in range(1, m):
          #这里表达就很妙！
            obstacleGrid[i][0] = obstacleGrid[i-1][0] * (1 - obstacleGrid[i][0]);
        for i in range(1, n):
            obstacleGrid[0][i] = obstacleGrid[0][i-1] * (1 - obstacleGrid[0][i]);
            
        for i in range(1, m):
            for j in range(1, n):
                obstacleGrid[i][j] = (obstacleGrid[i-1][j] + obstacleGrid[i][j-1]) * (1 - obstacleGrid[i][j]);
        return obstacleGrid[-1][-1]
```

参考了一下别人的思路，可以不用三元表达式直接用乘法！
