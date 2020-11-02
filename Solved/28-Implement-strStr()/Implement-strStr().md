

# 28. Implement strStr()

### 题目

链接：https://leetcode.com/problems/implement-strstr/



### 思路

#### 步骤

- 傻瓜步骤3号



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Python

```python
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        res = 0
        if needle == "":
            return 0
        for i in range(0, len(haystack)):
            if haystack[i:i+len(needle)] == needle:
                return i
        return -1
```



## Python知识点

### String取子串的方法

```
str = ’0123456789′
print str[0:3] #截取第一位到第三位的字符
print str[:] #截取字符串的全部字符
print str[6:] #截取第七个字符到结尾
print str[:-3] #截取从头开始到倒数第三个字符之前
print str[2] #截取第三个字符
print str[-1] #截取倒数第一个字符
print str[::-1] #创造一个与原字符串顺序相反的字符串
print str[-3:-1] #截取倒数第三位与倒数第一位之前的字符
print str[-3:] #截取倒数第三位到结尾
print str[:-5:-3] #逆序截取，具体啥意思没搞明白？
```

