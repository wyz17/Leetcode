# 347. Top K Frequent Elements

### 题目

- 链接：https://leetcode.com/problems/top-k-frequent-elements/



### 思路1 - Heap

#### 步骤

- 利用一个map存储数组中每一个数字出现的频率
- 通过维护一个元素数目为 k 的最小堆，每次都将新的元素与堆顶端的元素（堆中频率最小的元素）进行比较，如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中



#### 复杂度

时间： `O(logN)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()) {
            pq.add(key);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        m = {}
        for num in nums:
            if num in m:
                m[num] -= 1
            else:
                m[num] = -1
        
        h = []
        from heapq import heappush, heappop
        for key in m:
            heappush(h, (m[key], key)) # freq, item - O(log(k)) sort by heap[0]
        res = []
        count = 0
        while count < k:
            freq, item = heappop(h)
            res.append(item)
            count += 1
        return res
```

