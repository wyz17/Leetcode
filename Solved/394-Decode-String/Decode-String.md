# 394. Decode String

### 题目

- 链接：https://leetcode.com/problems/decode-string/



### 思路 - Stack

#### 步骤

- 使用两个栈来保存
  - Integer栈保存num，代表当前子字符串需要重复的次数
  - String栈保存子字符串，代表需要重复的子字符串
- 遍历当前的字符串，判断各个字符对应的操作
  - 数字
    - 将获取的字符转为数字，更新至num
  - [
    - 将当前数字存入栈中，数字更新为0
    - 将当前字符串存入栈中，字符串更新为空
  - ]
    - 从int栈中取出数字，代表重复的次数
    - 从str栈中取出字符串，代表需要重复的字符串
    - 将res更新
  - 如果当前字符均不是上面选项，res直接添加字符





#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder cur = new StringBuilder();
        Stack<Integer> intStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            else if(c == '[') {
                intStk.push(num);
                strStk.push(cur);
                cur = new StringBuilder();
                num = 0;
            }
            else if(c == ']') {
                StringBuilder tmp = cur;
                cur = strStk.pop();
                for (num = intStk.pop(); num > 0; num--) {
                    cur.append(tmp);
                }
            }
            else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
```



##### Python

```python
class Solution:
    def decodeString(self, s: str) -> str:
        num = 0
        istk = []
        sstk = []
        res = ""
        
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == '[':
                istk.append(num)
                num = 0
                sstk.append(res)
                res = ""
            elif c == ']':
                tmp = res
                tmp_num = istk.pop()
                res = sstk.pop()
                while tmp_num > 0:
                    res = res + tmp
                    tmp_num -= 1
                num = 0
            else:
                res += c
        return res
```