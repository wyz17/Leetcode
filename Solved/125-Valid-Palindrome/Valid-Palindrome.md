

# 125. Valid Palindrome

### 题目

链接：https://leetcode.com/problems/valid-palindrome/



### 思路1 - 双指针

#### 步骤

- 前后设置两个指针
- 遍历判断字符是否一致：用方法  ```Character.isLetterOrDigit```
- 注意判断字符的大小写：```.toLowerCase() ``` 或者 ``` .lower()```



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) { return true; }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        return true;
    }
}
```



##### Python

```python
class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not s[l].isalnum():
                l += 1
            while l < r and not s[r].isalnum():
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        return True
```



### 思路2 - 正则表达式

#### 步骤

- 用正则表达式替换掉除了数字字母之外多余的符号
- reverse，判断与原字符串是否相同



#### 复杂度

时间：` O(n)`

空间：` O(n)` 会用到额外空间，不推荐



#### 代码

##### Java

```java
public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
```


