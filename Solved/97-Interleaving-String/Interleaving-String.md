# 97. Interleaving String

### 题目

- 链接：https://leetcode.com/problems/interleaving-string/



### 思路1 - Dynamic Programming

#### 步骤

- 使用一个二维数组 dp\[i][j] 用来保存状态

- dp\[i][j]：当s1取前```i``` 个，s2取前 ```j``` 个，是否可以组成s3取前 ```i+j``` 个

- 递推公式：

  ```java
  dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
  ```



#### 复杂度

时间： `O(M^N)`

空间：` O(M^N)`



#### 代码

##### Java

```java
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
```



##### Python

```python

```



### 思路2 - DFS

#### 步骤

- TBC：https://leetcode.com/problems/interleaving-string/discuss/31888/1ms-tiny-DFS-beats-94.57





#### 复杂度

时间： `O(M*N)`

空间：` O(M*N)`



#### 代码

##### Java

```java

```



##### Python

```python

```

