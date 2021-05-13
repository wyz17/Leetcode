

# 383. Ransom Note

### 题目

链接：https://leetcode.com/problems/ransom-note/description/



### 思路 - Array

#### 步骤

- 遍历magazine，将字符存入数组
- 遍历ransomNote，将数组中字符--
- 判断是否存在负数



#### 复杂度

时间： `O(n)`

空间：` O(1)`，因为字母一共就是26个，所以是常数空间

Python的方法真是 妙啊！



#### 代码

##### Java

```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ch = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            ch[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            ch[ransomNote.charAt(i) - 'a']--;
            if(ch[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
```



##### Python

```python
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        for c in set(ransomNote):
            if magazine.count(c) < ransomNote.count(c):
                return False
        return True
```