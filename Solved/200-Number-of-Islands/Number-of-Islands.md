

# 200. Number of Islands

### 题目

链接：https://leetcode.com/problems/number-of-islands/



### 思路1 - BFS

#### 步骤

- 利用队列存储多个节点
- 视频讲解Source：https://www.bilibili.com/video/av73239905



#### 复杂度

时间： `O(n * m)`

空间：` O(n * m)`



#### 代码

##### Java

```java
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '*';
                    q.offer(new int[]{i, j});
                    bfs(grid, q);
                }
            }
        }
        return res;
    }
    
    private void bfs(char[][] grid, Queue<int[]> q) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                
                // check boundary
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') continue;
                
                // label point into visited point
                grid[x][y] = '*';
                q.offer(new int[]{x, y});
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        q = []
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    res += 1
                    grid[i][j] = '0'
                    q.append([i, j])
                    self.bfs(grid, q)
        return res
    
    def bfs(self, grid, q):
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        while q:
            cur = q.pop()
            for dir in dirs:
                x = dir[0] + cur[0]
                y = dir[1] + cur[1]
                
                if x < 0 or x >= len(grid) or y < 0 or y >= len(grid[0]) or grid[x][y] != '1':
                    continue
                grid[x][y] = '0'
                q.append([x, y])
```



### 思路2 - DFS

#### 步骤

- dfs递归思路



#### 复杂度

时间： `O(n * m)`

空间：` O(n * m)`



#### 代码

##### Java

```java
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
```



##### Python

```python
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        q = []
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    res += 1
                    self.dfs(grid, i, j)
        return res
    
    def dfs(self, grid, i, j):
        if i >= 0 and j >= 0 and i < len(grid) and j < len(grid[0]) and grid[i][j] == '1':
            grid[i][j] = '0'
            self.dfs(grid, i - 1, j)
            self.dfs(grid, i + 1, j)
            self.dfs(grid, i, j + 1)
            self.dfs(grid, i, j - 1)
```

