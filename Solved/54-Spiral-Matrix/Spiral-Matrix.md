

# 54. Spiral Matrix

### 题目

链接：https://leetcode.com/problems/spiral-matrix/



### 思路

#### 步骤

- 按照题意直接列循环就好啦



#### 复杂度

时间：` O(N x M)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;

        while(minRow <= maxRow && minCol <= maxCol) {
            //left-top  ->  right-top
            for (int i = minCol; i <= maxCol; i++) {
                res.add(matrix[minRow][i]);
            }
            //right-top  ->  right-bottom
            for (int i = minRow + 1; i <= maxRow; i++) {
                res.add(matrix[i][maxCol]);
            }
            
            //right-bottom  ->  left-bottom
            if (minRow != maxRow) {
                for (int i = maxCol - 1; i >= minCol; i--) {
                    res.add(matrix[maxRow][i]);
                }
            }
            
            //left-bottom  ->  left-top
            if (minCol != maxCol) {
                for (int i = maxRow - 1; i > minRow; i--) {
                    res.add(matrix[i][minCol]);
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
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix or not matrix[0]:
            return []
        res = []
        minRow, minCol, maxRow, maxCol = 0, 0, len(matrix) - 1, len(matrix[0]) - 1
        
        while minRow <= maxRow and minCol <= maxCol:
            
            # l-t -> r-t
            for i in range(minCol, maxCol + 1): res.append(matrix[minRow][i])
            # r-t -> r-b
            for i in range(minRow + 1, maxRow + 1): res.append(matrix[i][maxCol])
            # r-b -> l-b
            if minRow != maxRow:
                for i in range(maxCol - 1, minCol, -1): res.append(matrix[maxRow][i])
            # l-b -> l-t
            if minCol != maxCol:
                for i in range(maxRow, minRow, -1): res.append(matrix[i][minCol])
            
            minCol = minCol + 1
            minRow = minRow + 1
            maxCol = maxCol - 1
            maxRow = maxRow - 1
            
        return res
        
```

调循环边界的时候还是蛮烦的。。



###### StefanPochmann大佬解法

```python
def spiralOrder(self, matrix):
    return matrix and [*matrix.pop(0)] + self.spiralOrder([*zip(*matrix)][::-1])
```

指路：https://leetcode.com/problems/spiral-matrix/discuss/20571/1-liner-in-Python-%2B-Ruby


