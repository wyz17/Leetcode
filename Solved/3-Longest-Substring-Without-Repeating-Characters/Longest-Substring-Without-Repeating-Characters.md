# 3. Longest Substring Without Repeating Characters

### 题目

链接：https://leetcode.com/problems/longest-substring-without-repeating-characters/



### 思路 - Sliding Window

- 利用set存储已有字符串中的数字（HashMap和字符数组都可以）
- left代表无重复字串的左边界；right代表无重复子串的右边界
- 遍历s中的每一个字符
  - 如果该字符没有在set中出现，将right添加进set，更新返回长度（当前无重复子串的长度是 ```right - left + 1``` ），right++
  - 否则的话在set中删掉左边的字符，left++



### 复杂度

时间：```O(n)```

空间：```O(1)```，set和map均为常数单位，因为字符是固定的数量



### 代码

#### Java

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                res = Math.max(res, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}
```



#### Python

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = set()
        left = right = res = 0
        while right < len(s):
            if s[right] not in map:
                map.add(s[right])
                res = max(res, right - left + 1)
                right += 1
            else:
                map.remove(s[left])
                left += 1
        return res
```



