

# 91. Decode Ways

### 题目

链接：https://leetcode.com/problems/decode-ways/



### 思路 - Dynamic Programming

#### 步骤

- 判断当前指针所指向的两位数是否大于26
  - 不是的话：dp[n] = dp[n-1] + dp[n-2]
  - 是的话：dp[n] = dp[n-1]



#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
        
        for(int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int first = s.charAt(i) - '0';
            int second = s.charAt(i + 1) - '0';
            if(first * 10 + second <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1]; 
            }
        }
        return dp[0];
    }
}
```



##### Python

```python
class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0 for x in range(len(s) + 1)] 
        dp[0] = 1
        dp[1] = 0 if s[0] == "0" else 1
        
        for i in range(2, len(s) + 1):
            if 0 < int(s[i-1:i]) <= 9:
                dp[i] += dp[i-1]
            if 10 <= int(s[i-2:i]) <= 26:
                dp[i] += dp[i-2]
        return dp[len(s)]
```



### 思路2 - DP空间优化

#### 步骤

- 用三个int值去存储dp的值，同样是使用斐波那契数列
- 这里要注意每次n3初始化为0，n1和n2更改值就好啦



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int n1 = 1;
        int n2 = s.charAt(0) != '0' ? 1 : 0;
        int n3 = 0;
        
        for(int i = 2; i < s.length() + 1; i++) {
            n3 = 0;
            int first = s.charAt(i - 1) - '0';
            int second = (s.charAt(i - 2) - '0') * 10 + first;
            if(s.charAt(i - 1) - '0' != 0) {
                n3 = n2;
            }
            if(second >= 10 && second <= 26) {
                n3 += n1;
            }
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
```



##### Python

```python
class Solution:
    def numDecodings(self, s: str) -> int:
        n1 = 1
        n2 = 0 if s[0] == "0" else 1
        n3 = 0
        
        for i in range(2, len(s) + 1):
            n3 = 0
            if 0 < int(s[i-1:i]) <= 9:
                n3 = n2
            if 10 <= int(s[i-2:i]) <= 26:
                n3 += n1
            n1 = n2
            n2 = n3
        return n2
```

