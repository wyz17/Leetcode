# 516. Longest Palindromic Subsequence

### 题目

- 链接：https://leetcode.com/problems/longest-palindromic-subsequence/
- 题意：返回给出字符串中的最大回文字符串，其中可以删除一个或者多个字符



### 思路 - Dynamic Programming

#### 步骤

- dp\[i][j]：表示子字符串 (i, j) 的最长回文子字符串长度，i表示字符串左边，j表示字符串右边

- 状态方程：

  - 如果左字符等于右字符，说明当前最长长度可以更新为（左边+1与右-1的值再加上新增的2个字符）

  - 如果不等于，就判断向左移一位和向右移一位那个子字符串更大

  - ```java
    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : Math.max(dp[i+1][j], dp[i][j-1])
    ```

- 初始化：

  - ```java
    dp[i][i] = 1
    ```



#### 复杂度

时间： `O(N^2)`

空间：` O(N^2)`



#### 代码

##### Java

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++){
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
```



##### Python

```python
class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        dp = [[0 for k in range(len(s))] for m in range(len(s))]
        for i in range(len(s) - 1, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, len(s)):
                if i == j:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i+1][j-1] + 2 if s[i] == s[j] else max(dp[i+1][j], dp[i][j-1])
        return dp[0][-1]
```