# 37. Sudoku Solver

### 题目

- 链接：https://leetcode.com/problems/sudoku-solver/
- 题意：解决数独问题



### 思路 - DFS

#### 步骤

- DFS递归
- tbc



#### 复杂度

时间： `O(9 ^ M)`，m代表需要填的空格数量

空间：` O(？)`



#### 代码

##### Java

```java
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {  //  try from 1 to 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; // Put c for this cell
                            if(solve(board))
                                return true; //if it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) return false; //check row
            if(board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
```



##### Python

```python
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or len(board) == 0: return
        self.solve(board)
        
    def solve(self, board):
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == '.':
                    for c in '123456789':
                        if self.isValid(board, i, j, c):
                            board[i][j] = c
                            if self.solve(board):
                                return True
                            else:
                                board[i][j] = '.'
                    return False
        return True
    
    def isValid(self, board, row, col, c):
        for k in range(9):
            if board[k][col] == c: return False
            if board[row][k] == c: return False
            if board[3 * (row // 3) + k // 3][3 * (col // 3) + k % 3] == c: return False
        return True
```

