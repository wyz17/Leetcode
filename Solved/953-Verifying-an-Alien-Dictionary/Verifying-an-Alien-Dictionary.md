# 953. Verifying an Alien Dictionary

### 题目

- 链接：https://leetcode.com/problems/verifying-an-alien-dictionary/
- 给出一串字符串代表字符顺序，和一个字符串数组，判断字符串数组中的所有字符串顺序是否按照题目给出的字符串顺序来排序



### 思路

#### 步骤

- 用map保存order中每一个字符的index，用于顺序判断
- 遍历字符串数组中的字符，根据map中的顺序判断大小
  - 遍历数组字符中的字符，判断顺序是否更大
  - 如果字符串长度不一样的话则还要判断长度的大小



#### 复杂度

时间： `O(NM)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    int[] map = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 1; i < words.length; i++) {
            if (bigger(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }
    private boolean bigger(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        for (int i = 0; i < n && i < m; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return map[s1.charAt(i) - 'a'] > map[s2.charAt(i) - 'a'];
            }
        }
        return m > n;
    }
}
```



##### Python

```python
class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        m = {ch: idx for idx, ch in enumerate(order)}
        for s1, s2 in zip(words, words[1:]):
            if len(s1) > len(s2) and s1[:len(s2)] == s2:
                return False
            for a, b in zip(s1, s2):
                if m[a] < m[b]:
                    break
                elif m[a] > m[b]:
                    return False
        return True
```


