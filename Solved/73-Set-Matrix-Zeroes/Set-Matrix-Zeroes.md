

# 71. Simplify Path

### 题目

链接：https://leetcode.com/problems/simplify-path/



### 思路

#### 步骤

- 使用第一行和第一列来记录行和列的置0情况（例如```matrix[2][3]```是0，就把```matrix[0][3]```和```matrix[2][0]```置为0）
- 首先，遍历第一行和第一列，看是否原先就有0，用两个bool变量来标识，如果原先就有0，最后要把有0的第一行或者第一列置为0
- 然后，用第一行和第一列来记录行和列的置0情况，为什么能这样做呢，因为假如```matrix[i][j]```为0，最终总要把```matrix[i][0]```和```matrix[0][j]```置为0
- 然后，遍历这个二维数组，如果发现```matrix[i][0]```或者```matrix[0][j]```为0，就把```matrix[i][j]```置为0
- 这样的做法只需要两个额外变量（即，来标识第一行或者第一列是否有0的两个bool值），所以空间复杂度是O(1)。
- 时间上需要进行两次扫描，一次确定行列置0情况，一次对矩阵进行实际的置0操作，所以总的时间复杂度是 O(m*n) 
- **简化版的要注意一下循环范围**



#### 复杂度

时间：` O(M * N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flg = true;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) flg = false;
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j > 0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(flg == false) matrix[i][0] = 0;
        }
    }
  
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = true;
        boolean row = true;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                row = false;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                col = false;
                break;
            }
        }        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(row == false) for(int i = 0; i < m; i++) matrix[i][0] = 0;
        if(col == false) for(int i = 0; i < n; i++) matrix[0][i] = 0;
    }
}
```



##### Python

```python
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])             
        col0 = 1
        
        for i in range(0, m):
            if matrix[i][0] == 0:
                col0 = 0
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
      
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, 0, -1):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
            if col0 == 0:
                matrix[i][0] = 0

    def setZeroes2(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        col, row = True, True
        for i in range(0, m):
            if matrix[i][0] == 0:
                row = False
                break
        for i in range(0, n):
            if matrix[0][i] == 0:
                col = False
                break                
                
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
      
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
        
        if row == False:
            for i in range(0, m):
                matrix[i][0] = 0
        if col == False:
            for i in range(0, n):
                matrix[0][i] = 0
```

