

# 151. Reverse Words in a String

### 题目

链接：https://leetcode.com/problems/reverse-words-in-a-string/



### 思路1

#### 步骤

- 用split分隔空格
- 再倒序拼接字符串



#### 复杂度

时间： `O(n)`

空间：` O(n)`

#### 代码

##### Java

```java
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" +");
        StringBuffer res = new StringBuffer();
        for(int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();
    }
}

//
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
```



##### Python

```python
class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(s.split()[::-1])   
```





### 思路2 - 适用于Reverse Words in a String II

#### 步骤

- 先整个字符串整体翻转一次
- 然后再分别翻转每一个单词（或者先分别翻转每一个单词，然后再整个字符串整体翻转一次）


