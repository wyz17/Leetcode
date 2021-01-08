

# 64. Minimum Path Sum

### 题目

链接：https://leetcode.com/problems/minimum-path-sum/



### 思路 - Dynamic Programming

#### 步骤

- dp一下：和前面 [Unique Paths](Solved/62-Unique-Paths/Unique-Paths.md) 的思路一样
- 状态方程：```grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j]```
- 意思是每一步的当前path是自己左边 + 上面 path之和

  



#### 复杂度

时间：` O(M * N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < m; i++)
            grid[i][0] = grid[i][0] + grid[i-1][0];
        for(int j = 1; j < n; j++)
            grid[0][j] = grid[0][j] + grid[0][j-1];
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
```



##### Python

```python
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0]);
        for i in range(1, m):
            grid[i][0] = grid[i][0] + grid[i-1][0]
        for i in range(1, n):
            grid[0][i] = grid[0][i] + grid[0][i-1]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
        return grid[-1][-1]
```
