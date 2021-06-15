# 567. Permutation in String

### 题目

链接：https://leetcode.com/problems/permutation-in-string/



### 思路 - Sliding Window

#### 步骤

- 滑动窗口思路
- 需要两个数组 need 和window：need用于存储目标值，window用于记录滑窗字符
- 这里由于s1的长度是固定的，所以我们其实不需要left去收缩左边的数组，只需要用一个指针记录就好
- 这里判断两个数组是否相等的方法：```Arrays.equals(window, need) ```





#### 复杂度

时间： `O(n)`

空间：` O(1)`，固定数组，所以是常数空间



#### 代码

##### Java

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] need = new int[26];
        int[] window = new int[26];
        for(char s: s1.toCharArray()) {
            need[s - 'a']++;
        }
        
        for(int right = 0; right< s2.length(); right++) {
            if(right >= s1.length()) {
                window[s2.charAt(right - s1.length()) - 'a']--; 
                //beacuse s1 is fixed length, so we do not need to calculate left
            }
            window[s2.charAt(right) - 'a']++;
            if(Arrays.equals(window, need)) {
                return true;
            }
        }
        return false;
    }
}
```



##### Python

```python
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False
        need = [0] * 26
        window = [0] * 26
        
        for i in range(0, len(s1)):
            need[ord(s1[i]) - ord('a')] += 1
        
        for j in range(0, len(s2)):
            if j >= len(s1):
                window[ord(s2[j - len(s1)]) - ord('a')] -= 1
            window[ord(s2[j]) - ord('a')] += 1
            if window == need:
                return True
        return False
```