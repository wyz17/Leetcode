

# 58. Length of Last Word

### 题目

链接：https://leetcode.com/problems/length-of-last-word/



### 思路

#### 步骤

- 傻瓜解法
- （优化的方法可以采用双指针，遍历一下就只是n的复杂度）



#### 复杂度

时间：` O(M x N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if(split.length == 0) return 0;
        return split[split.length - 1].length();
    }
}
```



##### Python

```java
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return len(s.strip().split(" ")[-1])
```


