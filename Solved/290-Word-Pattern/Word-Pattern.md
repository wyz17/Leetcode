# 290. Word Pattern

### 题目

- 链接：https://leetcode.com/problems/word-pattern/
- 题意：给出匹配的两个字符串，判断两者是否匹配



### 思路 - HashMap

#### 步骤

- 用map来记录pattern与string的映射
- 题目是双向映射，java中可以直接使用containsValue的方法来判断值中是否包含已经访问的字符串



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else {
                if(map.containsValue(strs[i])) return false;
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}
```



##### Python

- 由于是双向映射，所以还需要一个HashMap来记录该元素是否被访问过（test case 👇）

- ```
  "abba"
  "dog dog dog dog"
  ```



```python
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        strs = s.split(' ')
        if len(pattern) != len(strs): return False
        m = {}
        mval = {}
        for i in range(len(pattern)):
            idx = pattern[i]
            if idx in m:
                if m[idx] != strs[i]:
                    return False
            else:
                if strs[i] in mval:
                    return False
                m[idx] = strs[i]
                mval[strs[i]] = True
        return True
```

