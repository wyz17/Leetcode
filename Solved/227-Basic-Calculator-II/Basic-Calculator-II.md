# 227. Basic Calculator II

### 题目

- 链接：https://leetcode.com/problems/basic-calculator-ii/
- 题意：将给出的字符串表达式的值计算出来，其中运算符包括 ``` +, -, *, /``` 和部分空格



### 思路1 - Stack

#### 步骤

- 遍历字符串，利用栈记录当前的数字
- 用变量num保存当前的数字，op保存当前数字前一个的运算符
- 当op遇到 + & - 的话，将num（即前一位数字）压入栈中
- 当op遇到 * & /，先出栈一个元素，再乘或除当前的num，将结果压入栈中
- 最后遍历栈中的数据，求和



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        s += '+';
        int num = 0;
        char op = '+';
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                continue;
            }
            if(c == ' ') continue;
            
            if(op == '+') stk.push(num);
            else if(op == '-') stk.push(-num);
            else if(op == '*') stk.push(stk.pop() * num);
            else if(op == '/') stk.push(stk.pop() / num);
            op = c;
            num = 0;
        }
        
        int res = 0;
        while(!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def calculate(self, s: str) -> int:
        if not s or len(s) == 0: return 0
        stk = []
        s += '+'
        num, op = 0, '+'
        for c in s:
            if c == ' ': continue
            if c.isdigit():
                num = num * 10 + int(c)
                continue
            if op == '+':
                stk.append(num)
            elif op == '-':
                stk.append(-num)
            elif op == '*':
                stk.append(stk.pop() * num)
            elif op == '/':
                stk.append(int(stk.pop() / num))
            op = c
            num = 0
        
        res = 0
        while stk:
            res += stk.pop()
        return res
```

