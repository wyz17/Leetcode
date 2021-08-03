# 692. Top K Frequent Words

### 题目

- 链接：https://leetcode.com/problems/top-k-frequent-words/



### 思路 - Heap

#### 步骤

- 利用一个map存储数组中每一个字符串出现的频率
- 通过维护一个元素数目为 k 的最小堆，每次都将新的元素与堆顶端的元素（堆中频率最小的元素）进行比较，如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
- 题目要求如果频率相等的话就按照字母表顺序对字符串进行排序
  - java中直接有可以用的方法``` a.compareTo(b)```
  - python中将String一同存入heap，heap会自动排序
- 排序顺序问题
  - Java
    - 重写heap的排序方式
    - 频率改为负数
    - 重新将结果存入res时逆序
  - python
    - 频率改为负数
    -  ```heappop[1]``` 从而实现Top K



#### 复杂度

时间： `O(NlogK)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        for(String key: map.keySet()) {
            pq.add(key);
        }
        
        List<String> res = new ArrayList();
        for(int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        m = {}
        for word in words:
             m[word] = m.get(word, 0) - 1
                
        h = []
        from heapq import heappush, heappop
        for key in m:
            heappush(h, (m[key], key))
        
        res = []
        for i in range(k):
            freq, item = heappop(h)
            res.append(item)
        return res
```

