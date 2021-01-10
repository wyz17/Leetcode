

# 76. Minimum Window Substring

### 题目

链接：https://leetcode.com/problems/minimum-window-substring/



### 思路

#### 步骤

- 滑动窗口方法



#### 复杂度

时间：` O(S + T)`

空间：` O(S + T)` 



#### 代码

##### Java

```java
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];        
        int left = 0, right = 0, valid = 0;
        
        for(char c : t.toCharArray())
            need[c - 'A']++;
        
        //return value
        int end = s.length() + 1;
        int start = 0;
        
        while(right < s.length()) {
            int r = s.charAt(right) - 'A';
            right++;
            if(need[r] != 0) {
                window[r]++;
                if(window[r] <= need[r]) valid++;
            }
            while(valid == t.length()) {
                if((right - left) < (end - start)) {
                    start = left;
                    end = right;
                }
                
                int l = s.charAt(left) - 'A';
                if(need[l] != 0) {
                    if(window[l] == need[l]) valid--;
                    window[l]--;
                }
                left++;
            }
        }
        return end == s.length() + 1 ? "" : s.substring(start, end);
    }
}
```



##### Python

```python
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = collections.Counter(t)
        l, r, i, j, missing = 0, 0, 0, 0, len(t)
        while r < len(s):
            if need[s[r]] > 0:
                missing -= 1
            need[s[r]] -= 1
            r += 1
            
            while missing == 0:
                if j == 0 or r - l < j - i:
                    i, j = l, r
                need[s[l]] += 1
                if need[s[l]] > 0:
                    missing += 1
                l += 1
        return s[i:j]
        
    
    def minWindow2(self, s: str, t: str) -> str:
        need = [0] * 128
        window = [0] * 128
        left, right, valid = 0, 0, 0
        start = 0
        end = len(s) + 1
        
        for i in t:
            need[ord(i) - ord('A')] += 1
        while right < len(s):
            r = ord(s[right]) - ord('A')
            right += 1
            if need[r] != 0:
                window[r] += 1
                if window[r] <= need[r]:
                    valid += 1
            while valid == len(t):
                if right - left < end - start:
                    end = right
                    start = left
                l = ord(s[left]) - ord('A')
                if need[l] != 0:
                    if window[l] == need[l]:
                        valid -= 1
                    window[l] -= 1
                left += 1
        return "" if end == len(s) + 1 else s[start:end]
            
```

