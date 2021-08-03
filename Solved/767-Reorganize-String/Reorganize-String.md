# 767. Reorganize String

### 题目

- 链接：https://leetcode.com/problems/reorganize-string/



### 思路1 - Heap

#### 步骤

- 利用一个map存储字符串中每一个字符出现的频率
- 维护一个元素数目为 k 的最大堆，按照字符出现频率排序
- 构建一个新的字符串res
  - 每次从堆中取出两个字符添加至res中，并且map中对应频率映射 - 1
  - 如果频率 > 0，则将对应字符重新加入heap中，重新排序再重复之前的步骤
  - 当字符串长度为奇数的时候，最后heap会还剩下一个单独的字符，将这个单独的字符添加到res就好
  - 剪枝trick：如果某个字符出现的频率大于总长度的一半了，那么必然会有两个相邻的字符出现，直接retrn空，可以在计算字符频率的时候直接返回



#### 复杂度

时间： `O(NlogN)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (s.length() + 1) / 2) return "";
            map.put(c, count);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char key: map.keySet()) {
            pq.add(key);
        }
        
        StringBuilder res = new StringBuilder("");
        while(!pq.isEmpty()) {
            char a = pq.poll();
            if(pq.isEmpty()) {
                res.append(a);
                break;
            }
            char b = pq.poll();
            res.append(a).append(b);
            map.put(a, map.get(a) - 1);
            map.put(b, map.get(b) - 1);
            if(map.get(a) > 0) pq.add(a);
            if(map.get(b) > 0) pq.add(b);
        }
        return res.toString();
    }
}
```



##### Python

```python
class Solution:
    def reorganizeString(self, s: str) -> str:
        m = {}
        for c in s:
            count = m.get(c, 0) - 1
            if count < (-len(s) - 1) / 2 :
                return ""
            m[c] = count
        
        h = []
        from heapq import heappush, heappop
        for key in m:
            heappush(h, (m[key], key))
        
        res = ""
        while h:
            freqA, a = heappop(h)
            if not h:
                res += a
                break
            freqB, b = heappop(h)
            res += a
            res += b
            m[a] += 1
            m[b] += 1
            if m[a] < 0: heappush(h, (m[a], a))
            if m[b] < 0: heappush(h, (m[b], b))
        return res
```

