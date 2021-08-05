# 224. Basic Calculator

### 题目

- 链接：https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
- 题意：将给出的字符串表达式的值计算出来，其中运算符包括``` +, -, (, )```和部分空格



### 思路 - Stack

#### 步骤

- 变量
  - 栈stk：存储对应的运算符和数字
  - res：结果，用来累计中间计算结果
  - num：字符串中遍历时获取的数字
  - op：记录运算符，为1则代表加，为-1则代表减
- 遍历当前的字符串，判断各个字符对应的操作
  - 数字
    - 将获取的字符转为数字，更新至num
    - 注意可能不止一位，多位数字的话前面的num乘10再累加
  - +
    - 将当前num加到res中
    - 因为是加号，所以将op置1
    - num则等于0
  - -
    - 将当前num加到res中
    - 剪号则将op置为 -1
    - num设为0，为了计算后续数字
  - ( 
    - 出现左括号的情况只可能是第一位 & 运算符后面 & 括号后面
    - 将原本的num & op存入栈中
    - 将res置0（为了重新计算括号内的数字）
  - ) 
    - 计算当前的num并加入res
    - num就等于res
    - res等于原来存入栈的num
    - op也等于原来存入栈的op





#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        int num = 0; //计算的中间值
        int sign = 1; // '+' 1, '-' -1
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            switch(cur) {
                case ' ': break;
                case '+':
                    res += sign * num;
                    sign = 1;
                    num = 0;
                    break;
                case '-':
                    res += sign * num;
                    sign = -1;
                    num = 0;
                    break;
                case '(':
                    stk.push(res);
                    stk.push(sign);
                    res = 0;
                    sign = 1;
                    break;
                case ')':
                    res += sign * num;
                    num = res;
                    sign = stk.pop();
                    res = stk.pop();
                    break;
                default:
                    num = num * 10 + cur - '0';
                    break;
            }
        }
        res += sign * num;
        return res;
    }
}
```



##### Python

```python
class Solution:
    def calculate(self, s: str) -> int:
        stk = []
        res = 0
        num = 0
        op = 1
        for c in s:
            if c == ' ': continue
            elif c == '+':
                res += op * num
                op = 1
                num = 0
            elif c == '-':
                res += op * num
                op = -1
                num = 0
            elif c == '(':
                stk.append(res)
                stk.append(op)
                res = 0
                op = 1
            elif c == ')':
                res += op * num
                num = res
                op = stk.pop()
                res = stk.pop()
            else:
                num = num * 10 + int(c)
        res += op * num
        return res
```