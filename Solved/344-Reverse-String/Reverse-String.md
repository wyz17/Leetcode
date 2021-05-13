

# 344. Reverse String

### 题目

链接：https://leetcode.com/problems/reverse-string/description/



### 思路

#### 步骤

- 傻瓜解法

**Life is short, use Python!**



#### 复杂度

时间： `O(n)`

空间：` O(1)`

#### 代码

##### Java

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
```



##### Python

```python
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        s.reverse()
```