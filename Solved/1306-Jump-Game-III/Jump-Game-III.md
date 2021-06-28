# 1306. Jump Game III

### 题目

- 链接：https://leetcode.com/problems/jump-game-iii/
- 题意：跳台阶问题，从start开始。当你在index i的时候可以选择跳到 i + arr[i] 或者 i - arr[i]，确认是否可以返回0



### 思路1 - BFS

#### 步骤

- BFS经典思路
- 注意用visited记录一下访问状态



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`



#### 代码

##### Java

```java
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[arr.length];
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(arr[cur] == 0) return true;
            int idx1 = cur + arr[cur];
            int idx2 = cur - arr[cur];
            if(idx1 >= 0 && idx1 < arr.length && !visited[idx1]) {
                q.offer(idx1);
                visited[idx1] = true;
            }
            if(idx2 >= 0 && idx2 < arr.length && !visited[idx2]) {
                q.offer(idx2);
                visited[idx2] = true;
            }
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        q = []
        q.append(start)
        visited = [False] * len(arr)
        
        while q:
            cur = q.pop(0)
            if arr[cur] == 0:
                return True
            idx1 = cur + arr[cur]
            if len(arr) > idx1 >= 0 and not visited[idx1]:
                q.append(idx1)
                visited[idx1] = True
            idx2 = cur - arr[cur]
            if len(arr) > idx2 >= 0 and not visited[idx2]:
                q.append(idx2)
                visited[idx2] = True
        return False;
```

