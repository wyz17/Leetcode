# 841. Keys and Rooms

### 题目

- 链接：https://leetcode.com/problems/keys-and-rooms/



### 思路 - BFS

#### 步骤

- BFS经典思路
- 注意一下0的处理：
  - 入队的第一个数字是0
  - 如果用set的话，要先将0保存至set然后再进行返回判断



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`



#### 代码

##### Java

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int room: rooms.get(cur)) {
                if(!visited.contains(room)) {
                    q.offer(room);
                    visited.add(room);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
```



##### Python

```python
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        q = [0]
        visited = [True] + [False] * (len(rooms) - 1)
        
        while q:
            cur = q.pop(0)
            for room in rooms[cur]:
                if not visited[room]:
                    q.append(room)
                    visited[room] = True
        return all(visited)
```

