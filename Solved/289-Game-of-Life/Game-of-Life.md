# 289. Game of Life

### 题目

- 链接：https://leetcode.com/problems/game-of-life/



### 思路

#### 步骤

- 因为题目要求不适用额外空间，所以直接在当前的矩阵中进行修改
- 题目中 0 - dead，1 - live；我们设置 2 - go die，3 - will live
- 预设好移动方向dirs数组，计算出相邻格子中属于1的格子数
- 根据相邻格子中1的数量来判断2还是3
- 最后遍历矩阵，更新0/1/2/3状态（直接求余2）



#### 复杂度

时间： `O(MN)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int[][] dir = {{1,-1}, {1,0}, {1,1}, {0,-1}, {0,1}, {-1,-1}, {-1,0}, {-1,1}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int live = 0;
                for(int[] d: dir) {
                    if(d[0] + i < 0 || d[0] + i >= board.length || d[1] + j < 0 || d[1] + j >= board[0].length) continue;
                    if(board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2) live++;
                }
                if(board[i][j] == 0 && live == 3) board[i][j] = 3;
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or len(board) == 0 or len(board[0]) == 0: return
        dirs = [[1, -1], [1, 1], [-1, 1], [-1, -1], [0, -1], [0, 1], [1, 0], [-1, 0]]
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                live = 0
                for d in dirs:
                    if i + d[0] >= len(board) or i + d[0] < 0 or j + d[1] >= len(board[0]) or j + d[1] < 0:
                        continue
                    if board[i + d[0]][j + d[1]] == 1 or board[i + d[0]][j + d[1]] == 2:
                        live += 1
                if board[i][j] == 0 and live == 3:
                    board[i][j] = 3
                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] %= 2
```
