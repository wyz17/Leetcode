

# 387. First Unique Character in a String

### 题目

链接：https://leetcode.com/problems/first-unique-character-in-a-string/description/



### 思路 - HashMap

#### 步骤

- 遍历存入map
- 再遍历一遍，找出第一个出现次数为1的字符



#### 复杂度

时间： `O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 2);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = collections.Counter(s)
        
        for index, ch in enumerate(s):
            if dic[ch] == 1:
                return index
        return -1
```
