

# 542. 01 Matrix

### 题目

- 链接：https://leetcode.com/problems/01-matrix/
- 题意：根据当前矩阵，求出矩阵中每一个值距离0的最近距离



### 思路 - BFS

#### 步骤

- 利用队列存储多个节点
- 利用BFS从0开始遍历， 对于每一个值为1的值，更新其距离
- 距离的计算需要添加一个循环，从而避免距离多次计算
- 注意：需要区别出原本值为1和距离为1



#### 复杂度

时间： `O(n * m)`

空间：` O(n * m)`



#### 代码

##### Java

```java
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        
        int distance = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            int[] cur = q.poll();
            for (int[] dir: dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != -1) continue;
                mat[x][y] = mat[cur[0]][cur[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
        return mat;
    }
}
```



##### Python

```python
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = []
        for i in range(0, len(mat)):
            for j in range(0, len(mat[0])):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append([i, j])
        
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        while q:
            size = len(q)
            cur = q.pop(0)
            for dir in dirs:
                x = cur[0] + dir[0]
                y = cur[1] + dir[1]
                
                if x < 0 or x >= len(mat) or y < 0 or y >= len(mat[0]) or mat[x][y] != -1:
                    continue
                mat[x][y] = mat[cur[0]][cur[1]] + 1
                q.append([x, y])
        return mat
```

