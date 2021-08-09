# 703. Kth Largest Element in a Stream

### 题目

- 链接：https://leetcode.com/problems/kth-largest-element-in-a-stream/
- 题意：设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。



### 思路 - Priority Queue / Heap

#### 步骤

- Java：优先队列自带排序算法，在初始化时如果不指定排序方式，则默认以自然方式排序，优先队列的头就会是以自然排序为基础的最小元素。
- Python：堆，python中的堆默认是最小堆
- 使用最小堆，维护当前队列头为第k大的值
- 添加大于第k大的值时，队列头就会被刷新
- 添加小于第k大的值时，队列头不变
- 最多只需要保存前k个值就好





#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class KthLargest {
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>(k);
        for(int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.offer(val);
        }
        else if(pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
```



##### Python

```python
class KthLargest:
    
    def __init__(self, k: int, nums: List[int]):
        self.pq = nums
        self.size = len(self.pq)
        self.k = k

        heapq.heapify(self.pq)
        while self.size > k:
            heapq.heappop(self.pq)
            self.size -= 1     

    def add(self, val: int) -> int:
        if len(self.pq) < self.k:
            heapq.heappush(self.pq, val)
        elif self.pq[0] < val:
            heapq.heapreplace(self.pq, val)
        return self.pq[0]
```

