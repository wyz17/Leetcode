# 139. Word Break

### 题目

- 链接：https://leetcode.com/problems/word-break/ 
- 题意：给出字典list和字符串，使用空格分割字符串，使得字符串被分割的每一个单词都是属于字典list中的单词。返回是否可分割。



### 思路 - Dynamic Programming

#### 步骤

- 使用boolean数组来保存状态，dp[i]的意思就是从0到i的子字符串是否可以分割
- 状态方程：```dp[i] = dp[i] && contain substring(j, i)```
- dp[0] 的意思就是子字符串s[0:0]（一个空串），这个是肯定可以分割当前字符串的，所以```dp[0] = true```



#### 复杂度

时间： `O(N^3)`，循环的复杂度是`O(N^3)`，但是substring的复杂度是`O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
            
        }
        return dp[s.length()];
    }
}
```



##### Python

```python
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s) + 1):
            for j in range(0, i):
                if s[j:i] in wordDict and dp[j]:
                    dp[i] = True
        return dp[len(s)]
```

