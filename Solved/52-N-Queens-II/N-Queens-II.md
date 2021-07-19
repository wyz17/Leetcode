# 52. N-Queens II

### 题目

- 链接：https://leetcode.com/problems/n-queens-ii/
- 题意：在一个 n x n的棋盘上放上n个queen，使得横、竖和两个对角线方向均不会同时出现两个queen，返回能够解决这个问题的queen摆放个数



### 思路 - DFS

#### 步骤

- 由于题目要求返回的是个数，所以不需要再去构建board了
- 这里使用三个Boolean数组去判断当前摆放的位置是否有效
  - 行（循环遍历）
  - 列（Boolean数组 cols）
  - 左对角线（Boolean数组 d1）
    - 对于同一条左对角线，row - col的值是相等的
    - 图中对角线所对应的index就是 [0, 2, 4, 6] => [**True**, False, **True**, False, **True**, False, **True**, False, False]
    - 数组初始化的长度是 2n
  - 右对角线（Boolean数组 d2）
    - 对于同一条右对角线，row + col 的值是相等的
    - 所以这里可以用 row - col表示数组index，由于 0 - 3是负数，所以在这里再加一个n
    - 图中对角线所对应的index就是 [1, 3, 5, 7] => [False, **True**, False, **True**, False, **True**, False, **True**, False]
    - 数组初始化长度为2n

![img](https://windliang.oss-cn-beijing.aliyuncs.com/52_2.jpg)



#### 复杂度

时间： `O(n!)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    private void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;
        
        for(int col = 0; col < n; col++) {
            int id1 = col - row + n; 
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;
            
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
```



##### Python

```python
class Solution:
    res = 0
    def totalNQueens(self, n: int) -> int:
        cols = [False] * n
        d1 = [False] * (2 * n)
        d2 = [False] * (2 * n)
        self.backtracking(0, cols, d1, d2, n)
        return self.res
    
    def backtracking(self, row, cols, d1, d2, n):
        if row == n:
            self.res += 1
        for col in range(n):
            id1 = col - row + n
            id2 = col + row
            if d1[id1] or d2[id2] or cols[col]:
                continue
                
            cols[col] = True
            d1[id1] = True
            d2[id2] = True
            self.backtracking(row + 1, cols, d1, d2, n);
            
            cols[col] = False
            d1[id1] = False
            d2[id2] = False
```
