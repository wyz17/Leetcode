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



### 思路2

#### 步骤

- 利用一个map存储字符串中每一个字符出现的频率

- 找出频率最大的字符，然后构造结果字符串（res字符数组）

  - 插空添加res，这样可以确保最高频率的字符不会出现相邻的值

- 判断添加的index

  - 如果添加完最大频率字符后，index大于字符串长度，说明最大频率字符刚好插完整个字符串
    - eg：```a _ a _ a```
    - 将index重设为1
  - 否则则继续换字符插入res，因为每个相邻位置的都已经被最大的字符添加了，所以后续添加不会再出现相邻值
    - eg：```a _ a _ b```

- 流程：

- ```
  a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
  a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
  a b a c a _ b _ b // fill in "c" at position 3
  a b a c a d b d b // fill in "d" at position 5, 7
  ```





#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public String reorganizeString(String s) {
        int[] map = new int[26];
        int max = 0;
        int letter = 0;
        for(char c: s.toCharArray()) {
            map[c - 'a']++;
            if (map[c - 'a'] > max) {
                max = map[c - 'a'];
                letter = c - 'a';
            }
            if (max > (s.length() + 1) / 2) return "";
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        while(map[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            map[letter]--;
        }
        for(int i = 0; i < map.length; i++) {
            while(map[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                map[i]--;
            }
        }
        return String.valueOf(res);
    }
}
```



##### Python

```python
class Solution:
    def reorganizeString(self, s: str) -> str:
        dic = collections.Counter(s)
        m, l = 0, ''
        for c in dic:
            if dic[c] > m:
                m, l = dic[c], c
        if m > (len(s) + 1) // 2:
            return ''
        
        res = [''] * len(s)
        idx = 0
        while dic[l] > 0:
            res[idx] = l
            idx += 2
            dic[l] -= 1
            
        for c in dic:
            time, letter = dic[c], c
            while dic[letter] > 0:
                if idx >= len(s):
                    idx = 1
                res[idx] = letter
                idx += 2
                dic[letter] -= 1
        return ''.join(res)
```

