

# 474. Ones and Zeroes

### 题目

链接：https://leetcode.com/problems/ones-and-zeroes/



### 思路 - Dynamic Programming 

#### 步骤

- dp\[i][j] 代表在第i个0和第j个1的时候，最大的子序列数量
- 遍历当前的字符串，计算出当前字符串中0和1的个数
- 递推公式：``` dp[i][j] = max(dp[i][j], dp[i - 0][j - 1] + 1) ```
  - 当前字符串 dp\[i][j] 中0的个数和1的个数分别小于m和n时，判断可不可以添加当前的字符串
    - 不可添加的情况：加上了当前的0和1的数量就超过了i和j，这个情况直接等于原dp\[i][j]
    - 可添加的情况：dp\[i - 0][j - 1] + 1
  - 否则直接等于dp\[i][j]



#### 复杂度

时间： `O(mn)`

空间：` O(mn)`



#### 代码

##### Java

```java
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s: strs) {
            int zero = 0;
            int one = 0;
            for(Character c: s.toCharArray()) {
                if(c == '0') zero++;
                else one++;
            }
            for(int i = m; i >= zero; i--) {
                for(int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
```



##### Python

```python
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for s in strs:
            zero = 0
            one = 0
            for c in s:
                if c == '0': zero += 1
                else: one += 1
            for i in range(m, zero - 1, -1):
                for j in range(n, one - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zero][j - one] + 1)
        return dp[m][n]
```


