# 994. Rotting Oranges

### 题目

- 链接：https://leetcode.com/problems/rotting-oranges/
- 题意：根据当前矩阵，判断矩阵中的orange是不是坏的（相邻就是坏的）



### 思路 - BFS

#### 步骤

- 注意计算count！



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        if(fresh == 0) return 0;
        
        int count = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? count - 1 : -1;
    }
}
```



##### Python

```python
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = []
        fresh = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append([i, j])
                if grid[i][j] == 1:
                    fresh += 1

        if fresh == 0: return 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        count = 0
        while q:
            count += 1
            size = len(q)
            for k in range(0, size):
                cur = q.pop(0)
                for dir in dirs:
                    x = cur[0] + dir[0]
                    y = cur[1] + dir[1]
                
                    if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y] == 1:
                        grid[x][y] = 2
                        q.append([x, y])
                        fresh -= 1
        return count - 1 if fresh == 0 else -1;
```
