# 221. Maximal Square

### 题目

- 链接：https://leetcode.com/problems/maximal-square/
- 题意：返回给出的二维矩阵中包含最大的数字全为1的正方形面积



### 思路 - Dynamic Programming

#### 步骤

- 使用二维数组dp来存储状态

- `dp[i][j]` 代表当前点左上方的正方形中面积最大的全为1的正方形面积

- 状态方程：

  - ```java
    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
    ```

  - 如果当前matrix值为1，当前dp数组中的值可以被更新为```dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]```中的最小值+1

  - 否则 dp\[i][j] 默认为0，由于数组初始化为0，所以可以省略

  - ![img](https://tva1.sinaimg.cn/large/008i3skNgy1gsq15trrs0j31ou0jo77b.jpg)



#### 复杂度

时间： `O(N^2)`

空间：` O(N^2)`



#### 代码

##### Java

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxEdge = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}
```



##### Python

```python
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix: return 0
        m , n = len(matrix), len(matrix[0])
        dp = [[ 0 for j in range(n + 1)] for i in range(m + 1)]
        maxEdge = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                    maxEdge = max(maxEdge, dp[i][j])
        return maxEdge * maxEdge
```

