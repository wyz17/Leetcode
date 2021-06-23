# 733. Flood Fill

### 题目

- 链接：https://leetcode.com/problems/flood-fill/
- 题意：根据当前矩阵，求出矩阵中每一个值距离0的最近距离



### 思路1 - BFS

#### 步骤

- 注意：现将当前节点的值设置为newColor再进行遍历



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        if(newColor != image[sr][sc]) {
            q.offer(new int[]{sr, sc});
        }
        bfs(image, q, newColor, image[sr][sc]);
        return image;
    }
    
    private void bfs(int[][] image, Queue<int[]> q, int newColor, int oldColor) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                image[cur[0]][cur[1]] = newColor;
                
                if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != oldColor) continue;
                q.offer(new int[]{x, y});
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        q = []
        if image[sr][sc] != newColor:
            q.append([sr, sc])
        self.bfs(image, newColor, q, image[sr][sc])
        return image
        
    def bfs(self, image, newColor, q, oldValue):
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            cur = q.pop(0)
            for dir in dirs:
                x = cur[0] + dir[0]
                y = cur[1] + dir[1]
            
                image[cur[0]][cur[1]] = newColor
            
                if 0 <= x < len(image) and 0 <= y < len(image[0]) and image[x][y] == oldValue:
                    q.append([x, y])
```



### 思路2 - DFS ✨

#### 步骤

- DFS遍历



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int color, int newColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color)
            return;
        image[i][j] = newColor;
        dfs(image, i+1, j, color, newColor);
        dfs(image, i, j+1, color, newColor);
        dfs(image, i-1, j, color, newColor);
        dfs(image, i, j-1, color, newColor);
    }    
}
```



##### Python

```python
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image[sr][sc] == newColor:
            return image
        self.dfs(image, sr, sc, image[sr][sc], newColor)
        return image
        
    def dfs(self, image, x, y, oldColor, newColor):
        if 0 <= x < len(image) and 0 <= y < len(image[0]) and image[x][y] == oldColor:
            image[x][y] = newColor
            self.dfs(image, x + 1, y, oldColor, newColor)
            self.dfs(image, x - 1, y, oldColor, newColor)
            self.dfs(image, x, y + 1, oldColor, newColor)
            self.dfs(image, x, y - 1, oldColor, newColor)
```

