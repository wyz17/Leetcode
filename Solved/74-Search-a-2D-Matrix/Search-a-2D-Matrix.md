

# 74. Search a 2D Matrix

### 题目

链接：https://leetcode.com/problems/search-a-2d-matrix/



### 思路 - Binary Search

Use binary search.

n * m matrix convert to an array => matrix\[x][y] => a[x * m + y]

an array convert to n * m matrix => a\[x] => matrix\[x / m][x % m]



#### 步骤

- 看上面的解释！想通了就非常容易啦！



#### 复杂度

时间：` O(NlogN)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid / n][mid % n] == target) return true;
            if(matrix[mid / n][mid % n] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        l = 0
        r = m * n - 1
        while l <= r:
            mid = l + (r - l) // 2
            if matrix[mid // n][mid % n] == target:
                return True
            if matrix[mid // n][mid % n] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False
```

