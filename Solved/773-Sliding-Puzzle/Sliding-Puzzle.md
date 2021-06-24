# 773. Sliding Puzzle

### 题目

- 链接：https://leetcode.com/problems/sliding-puzzle/
- 题意：给出结果的board，判断移动多少步可以达成结果的样子，就是个简单的华容道



### 思路 - BFS

#### 步骤

- 将每一个矩阵当作一个图，将当前的图转变为一个按顺序的字符串，所以我们就需要找到当前字符串与结果“123450”的最小距离

- 用BFS进行遍历，然后计算出每一个我们走过的阶段level

- 每次移动字符串中0的位置来寻找下一个状态：这里可以使用一个二维数组保存每次移动的状态👇

- ```
  // 0每次移动的可能性
  0 1 2
  3 4 5 --> 0 can go to {1, 3}
  
  1 0 2
  3 4 5 --> 0 can go to index of {0,2,4}
  
  1 2 0
  3 4 5 --> 0 can go to {1, 5}
  
  1 2 3
  0 4 5 --> 0 can go to {0,4}
  
  1 2 3
  4 0 5 --> 0 can go to {1, 3, 5}
  
  1 2 3
  4 5 0 --> 0 can go to {2, 4}
  ```

- 用一个hashtable来存储访问过的状态，如果该节点已经被访问过了，就continue



#### 复杂度

时间： `O(6 * 6!)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuffer start = new StringBuffer("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start.append(board[i][j]);
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        
        Queue<String> q = new LinkedList<>();
        q.offer(start.toString());
        visited.add(start.toString());
        int res = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                for(int dir: dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    q.offer(next);
                }
            }
             res++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
```



##### Python

```python
class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        start = ""
        target = "123450"
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                start += str(board[i][j])
        q = []
        visited = set()
        dirs = {0: [1, 3], 1: [0, 2, 4], 2: [1, 5], 3: [0, 4], 4: [1, 3, 5], 5: [2, 4]}
        q.append(start)
        visited.add(start)
        
        res = 0
        while q:
            size = len(q)
            for k in range(size):
                cur = q.pop(0)
                if cur == target:
                    return res
                zero = cur.index('0')
                for dir in dirs[zero]:
                    ch = [c for c in cur]
                    ch[zero], ch[dir] = ch[dir], ch[zero]
                    next = ''.join(ch)
                    if next in visited:
                        continue
                    visited.add(next)
                    q.append(next)
            res += 1
        return -1
```
