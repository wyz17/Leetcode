# 763. Partition Labels

### 题目

- 链接：https://www.lintcode.com/problem/680/solution
- 题意：分割给出的字符串，确保子串中出现的每一个字符只会在当前的子串中出现



### 思路

#### 步骤

- 利用一个index为char的数组存储每一个字符最后的出现位置
- 遍历字符串，记录当前子字符串的start，end
  - end更新为当前字符的终点和当前index的最大值
  - 当end等于当前index时，更新start，同时将当前子字符串添加到res



#### 复杂度

时间： `O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0) return res;
        
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(map[s.charAt(i) - 'a'], end);
            if(i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        if not s or len(s) == 0: return res
        
        m = {}
        for idx, c in enumerate(s):
            m[c] = idx
        
        start, end = 0, 0
        for idx, c in enumerate(s):
            end = max(m[c], end)
            if idx == end:
                res.append(end - start + 1)
                start = idx + 1
        return res
```