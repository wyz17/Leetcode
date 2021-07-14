# 51. N-Queens

### 题目

- 链接：https://leetcode.com/problems/n-queens/
- 题意：在一个 n x n的棋盘上放上n个queen，使得横、竖和两个对角线方向均不会同时出现两个queen



### 思路 - DFS

#### 步骤

- It picks an element as pivot and partitions the given array around the picked pivot
- 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据比另一部分的所有数据要小，再按这种方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，使整个数据变成有序序列



#### 复杂度

时间： `O((n^3) * n!)`

空间：` O(n^2)`



#### 代码

##### Java

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                // check for queen
                // 1. no confict in columns: self explanatory as we put 'Q' col by col
                // 2. no confict in rows: x == i
                // 3. no conflict in diagonals: Math.abs(x-i) == Math.abs(y-j)
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }
    
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
```



##### Python

- N皇后问题有个技巧的关键在于棋盘的表示方法，这里使用一个数组就可以表达了
  - 比如 board = [1, 3, 0, 2]，这是4皇后问题的一个解
  - 意思是：在第0行，皇后放在第1列；在第1行，皇后放在第3列；在第2行，皇后放在第0列；在第3行，皇后放在第2列
- valid函数用来检查第n个queen是否可以放在那一行

```python
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        self.dfs([-1] * n, 0, [], res)
        return res
    
    def dfs(self, nums, idx, path, res):
        if idx == len(nums):
            res.append(path)
            return
        for i in range(len(nums)):
            nums[idx] = i
            if self.valid(nums, idx):
                tmp = '.' * len(nums)
                self.dfs(nums, idx + 1, path + [tmp[:i] + "Q" + tmp[i+1:]], res)
            
    def valid(self, nums, n):
        for i in range(n):
            if abs(nums[i] - nums[n]) == n - i or nums[i] == nums[n]:
                return False
        return True  
```
