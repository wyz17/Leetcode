# 51. N-Queens

### 题目

- 链接：https://leetcode.com/problems/n-queens/
- 题意：在一个 n x n的棋盘上放上n个queen，使得横、竖和两个对角线方向均不会同时出现两个queen



### 思路 - Backtracking

#### 步骤

- 从行开始遍历，行内循环遍历列
- 使用三个Boolean数组来判断当前组合是否valid：标记是否被占有
- 当列遍历到n的时候就回退



#### 复杂度

时间： `O(n!)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
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
