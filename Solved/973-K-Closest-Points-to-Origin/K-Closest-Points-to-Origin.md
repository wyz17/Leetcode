# 973. K Closest Points to Origin

### 题目

- 链接：https://leetcode.com/problems/reorganize-string/



### 思路1 - Heap

#### 步骤

- 不需要map存储啦
- 维护一个元素数目为 k 的最大堆，重写排序方法



#### 复杂度

时间： `O(NlogK)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for(int[] point: points) {
            pq.offer(point);
        }
        
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        h = []
        for (x, y) in points:
            dist = -(x * x + y * y)
            if len(h) == k:
                heapq.heappushpop(h, (dist, x, y))
            else:
                heapq.heappush(h, (dist, x, y))
        return [(x,y) for (dist, x, y) in h]
```

