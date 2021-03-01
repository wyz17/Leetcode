

# 120. Triangle

### 题目

链接：https://leetcode.com/problems/triangle/



### 思路1 - Dynamic Programming

#### 步骤

- 直接复用triangle数组，使得 triangle\[i][j] 是从最顶层到 (i, j) 位置的最小路径和
- 状态转移方程：triangle [i] [j] = min(triangle \[i - 1] [j - 1], triangle\[i - 1] [j])



#### 复杂度

时间：` O(n^2)`

空间：` O(1)`



#### 代码

##### Java

```java
//Go from bottom to top.
//We start form the row above the bottom row [size()-2].
//Each number add the smaller number of two numbers that below it.
//And finally we get to the top we the smallest sum.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
```



##### Python

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        row = len(triangle) - 1
        maxCol = len(triangle[row]) - 1
        for i in range(1, row + 1):
            for j in range(0, len(triangle[i])):
                if 0 < j < len(triangle[i]) - 1:
                    triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j])
                elif j == 0:
                    triangle[i][j] += triangle[i-1][j] 
                else:
                    triangle[i][j] += triangle[i-1][-1]
                    
        return min(triangle[-1])
```



### 思路2 - Dynamic Programming 优化

#### 步骤

- 自底向上dp
- 递推公式是： dp\[i][j] = dp\[i+1][j] + dp\[i+1][j+1] ，当前这个点的最小值，由他下面那一行临近的2个点的最小值与当前点的值相加得到
- 由于是三角形，且历史数据只在计算最小值时应用一次，所以无需建立二维数组，每次更新1维数组值，最后那个值里存的就是最终结果



#### 复杂度

时间：` O(n^2)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
```



##### Python

```python
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [0] * (len(triangle) + 1)
        for i in range(len(triangle) - 1, -1, -1):
            for j in range(0, len(triangle[i])):
                dp[j] = min(dp[j], dp[j + 1]) + triangle[i][j]
        return dp[0]
```



