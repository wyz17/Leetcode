

# 36. Valid Sudoku

### 题目

链接：https://leetcode.com/problems/valid-sudoku/

给出一个二维数组（九宫格），判断这个数组是否是一个有效的数独



### 思路

#### 步骤

- 遍历每一个 行 & 列 & 方格，判断有没有重复的值
- 行列很好确定，但如何确定box的序号？
  - index = row / 3 * 3 + col / 3 （这里的除法都是整除）



#### 复杂度

时间：` O(1)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        
        //check for col
        for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++) {
               if(board[i][j] == '.') continue;
               if(set.contains(board[i][j])) return false;
               set.add(board[i][j]);
           }
            set.clear();
        }
        
        
        //check for row
        for(int j = 0; j < 9; j++){
           for(int i = 0; i < 9; i++) {
               if(board[i][j] == '.') continue;
               if(set.contains(board[i][j])) return false;
               set.add(board[i][j]);
           }
            set.clear();
        }
        
        //check for box
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                    if(board[i][j] == '.') continue;
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        return true;
    }
}
```



Po一个大佬的解法：

真的太妙了！

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if(!set.add(i + s) || !set.add(s + j) || !set.add(i/3 + s + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
```



##### Python

根据大佬思路写的！

```python
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        nums = set()
        for i in range(0, 9):
            for j in range(0, 9):
                if board[i][j] != '.':
                    s = '%s%s%s' % ('(', board[i][j], ')')
                    row = '%s%s' % (i, s)
                    col = '%s%s' % (s, j)
                    box = '%s%s%s' % (i//3, s, j//3)
                    if row in nums or col in nums or box in nums:
                        return False
                    else:
                        nums.add(row)
                        nums.add(col)
                        nums.add(box)
        return True    
```


