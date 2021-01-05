

# 59. Spiral Matrix II

### 题目

链接：https://leetcode.com/problems/spiral-matrix-ii/



### 思路

#### 步骤

- 按照题意直接列循环就好啦
- 思路和 [Spiral Matrix](Solved/54-Spiral-Matrix/Spiral-Matrix.md)一样



#### 复杂度

时间：` O(N x M)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        int cur = 1;

        while(minRow <= maxRow && minCol <= maxCol && cur <= n * n) {
            //left-top  ->  right-top
            for (int i = minCol; i <= maxCol; i++) {
                res[minRow][i] = cur;
                cur++;
            }
            //right-top  ->  right-bottom
            for (int i = minRow + 1; i <= maxRow; i++) {
                res[i][maxCol] = cur;
                cur++;
            }
            
            //right-bottom  ->  left-bottom
            if (minRow != maxRow) {
                for (int i = maxCol - 1; i >= minCol; i--) {
                    res[maxRow][i] = cur;
                    cur++;
                }
            }
            
            //left-bottom  ->  left-top
            if (minCol != maxCol) {
                for (int i = maxRow - 1; i > minRow; i--) {
                    res[i][minCol] = cur;
                    cur++;
                }
            }
            minRow++;
            minCol++;
            maxRow--;
            maxCol--;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        res = [[0 for i in range(n)] for j in range(n)]
        minRow, minCol, maxRow, maxCol, cur = 0, 0, n - 1, n - 1, 1
    
        while minRow <= maxRow and minCol <= maxCol and cur <= n * n:         
            # l-t -> r-t
            for i in range(minCol, maxCol + 1):
                res[minRow][i] = cur
                cur = cur + 1
                
            # r-t -> r-b
            for i in range(minRow + 1, maxRow + 1):
                res[i][maxCol] = cur
                cur = cur + 1
                
            # r-b -> l-b
            if minRow != maxRow:
                for i in range(maxCol - 1, minCol, -1):
                    res[maxRow][i] = cur
                    cur = cur + 1
                    
            # l-b -> l-t
            if minCol != maxCol:
                for i in range(maxRow, minRow, -1):
                    res[i][minCol] = cur
                    cur = cur + 1
            
            minCol = minCol + 1
            minRow = minRow + 1
            maxCol = maxCol - 1
            maxRow = maxRow - 1
        return res
```



###### StefanPochmann大佬解法

```python
def generateMatrix(self, n):
    A, lo = [], n*n+1
    while lo > 1:
        lo, hi = lo - len(A), lo
        A = [range(lo, hi)] + zip(*A[::-1])
    return 
```

指路：https://leetcode.com/problems/spiral-matrix-ii/discuss/22282/4-9-lines-Python-solutions


