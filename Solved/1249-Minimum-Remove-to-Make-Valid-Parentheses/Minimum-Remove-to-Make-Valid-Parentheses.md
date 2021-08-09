# 1249. Minimum Remove to Make Valid Parentheses

### 题目

链接：https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/



### 思路

#### 步骤

- 使用一个栈来保存左括号的index
- 遍历字符串
  - 遇到左括号：入栈
  - 遇到右括号
    - 如果栈不为空，则出栈一个
    - 如果栈为空，则将当前index的字符串替换为空或者其他字符，因为这是明确要消除的字符
- 最后遍历栈，将栈中index保存下来所有位置的字符置空





#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack();
        StringBuilder res = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stk.push(i);
            }
            if(c == ')') {
                if(!stk.isEmpty()) {
                    stk.pop();
                } else {
                    res.setCharAt(i, '*');
                }
            }
        }
        while (!stk.empty()) {
            res.setCharAt(stk.pop(), '*');
        }
        return res.toString().replaceAll("\\*", "");
    }
}
```



##### Python

```python
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        s = list(s)
        stk = []
        for idx, c in enumerate(s):
            if c == '(':
                stk.append(idx)
            elif c == ')':
                if stk:
                    stk.pop()
                else:
                    s[idx] = ''
        while stk:
            i = stk.pop()
            s[i] = ""
        return ''.join(s)
```

