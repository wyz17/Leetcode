# 395. Longest Substring with At Least K Repeating Characters

### 题目

链接：https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/



### 思路1 - Two Pointers

#### 步骤

- 固定“滑窗里不同字母的个数”，这个数目m可以从1遍历到26（这样就包含了字符串子串的每一种可能性，因为滑窗中不同字母的个数不可能超过26个）
- 跑26遍的滑窗，每一遍把包含的不同的字符确定下来；之后再判断里面每一个字符出现的次数满不满足条件
- 只要固定了左指针和区间不同字母的个数，那么我们就可以确定右指针最远的位置，然后查看区间内是否每个字母出现的频次都大于k
- 最后的答案就是遍历所有m时能够得到的最大滑窗长度



#### 复杂度

时间： `O(26n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        int res = 0;
        for(int i = 0; i < 26; i++) {
            int[] map = new int[26];
            int unique = 0;
            int left = 0, right = 0;
            while(right < s.length()) {
                boolean valid = true;
                if(map[s.charAt(right) - 'a']++ == 0) { // add new unique character
                    unique++;
                }
                right++;
                while(unique > i) { // ?
                    if(map[s.charAt(left++) - 'a']-- == 1) { // judge whether this character appear less than once
                        unique--;
                    }
                }
                for(int j = 0; j < 26; j++) {   // judge whether exist invalid character
                    if(map[j] > 0 && map[j] < k) {  // have arr[j] > 0 to ensure presence
                        valid = false;
                        break;
                    }
                }
                if(unique == i && valid){ 
                    res = Math.max(res, right - left);
                }
            }
        }
        return res;
    }
}
```





### 思路2 - Recursive

#### 步骤

- 首先出现小于k次的字符一定不会出现在要求的子串中，因此统计字符串中每个字符出现的次数
- 以小于k次的字符为分割点，将字符串分割为几个小片段
- 对每个小片段，我们仍需要判断它是否满足每个字符出现次数不小于k，所以对每个小片段递归分割
- 终止条件是片段中每个字符次数都不小于k时返回片段长度



#### 复杂度

时间： `O(n*2)`

空间：` O(1)`



#### 代码



##### Python

```python
class Solution(object):
    def longestSubstring(self, s, k):
        for c in set(s):
            if s.count(c) < k:
                return max(self.longestSubstring(t, k) for t in s.split(c))
        return len(s)
```