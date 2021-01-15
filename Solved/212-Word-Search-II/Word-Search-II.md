

# 212. Word Search II

### 题目

链接：https://leetcode.com/problems/word-search-ii/



### 思路 - Trie

https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)



#### 步骤

- DFS



#### 复杂度 ?

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || board[i][j] == '#') {
            return false;
        }
        
        char tmp = board[i][j];
        board[i][j] = '#';
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)) {
            return true;
        }
        
        board[i][j] = tmp;
        return false;
    }
}
```



##### Python

```python
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        print(word[0])
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if word[0] == board[i][j] and self.search(board, word, i, j, 0):
                    return True
        return False
    
    def search(self, board, word, i, j, index):
        if index == len(word):
            return True
        if i >= len(board) or i < 0 or j >= len(board[0]) or j < 0 or board[i][j] != word[index] or board[i][j] == "#":
            return False
        
        tmp = board[i][j]
        board[i][j] = "#"
        if self.search(board, word, i + 1, j, index + 1) or self.search(board, word, i, j + 1, index + 1) or self.search(board, word, i - 1, j, index + 1) or self.search(board, word, i, j - 1, index + 1):
            return True
        
        board[i][j] = tmp
        return False
```



### 优化 - TBC

https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space./193004