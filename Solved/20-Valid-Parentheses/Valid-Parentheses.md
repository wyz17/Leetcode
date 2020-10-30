

# 20. Valid Parentheses

### 题目

链接：https://leetcode.com/problems/valid-parentheses/



### 思路1 - Stack

#### 步骤

- 先用map存好对应括号的映射
- 遍历字符串，如果是左括号，则存入右括号
- 遇到右括号，判断栈顶是否相等，不相等/为空就return false
- 最后判断栈是否为空



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

``` java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('(', ')');
        mappings.put('[', ']');
        mappings.put('{', '}');
        
        Stack<Character> stk = new Stack<>();
        for(char i: s.toCharArray()){
            if(mappings.containsKey(i))
                stk.push(mappings.get(i));
            else if(mappings.containsValue(i)){
                if(stk.isEmpty() || stk.pop() != i)
                    return false;
            }
        }
        return stk.isEmpty();
    }
}
```



不用map映射的代码更快：

```java
class Solution {
    public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
    }
}
```



##### Python

```python
class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        mapping = dict(zip("{[(","}])"))
        for i in s:
            if i in mapping:
                stk.append(i)
            elif not stk or mapping[stk.pop()] != i:
                return False
        return True
```





### 思路2 - 字符串replace

#### 步骤

- 这个思路太巧妙了直接看代码吧



#### 复杂度

时间：` O(N*2)`，费时间

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean isValid(String s) {
        while(s.contains("{}") || s.contains("()") || s.contains("[]")){
            s = s.replace("{}", "").replace("()", "").replace("[]", "");
        }
        return s == "";
    }
}
```



##### Python

```python
class Solution:
    def isValid(self, s: str) -> bool:
        while "()" in s or "{}" in s or '[]' in s:
            s = s.replace("()", "").replace('{}', "").replace('[]', "")
        return s == ''
```



### Python知识点

- Python中没有null  ->  替代：None

- zip函数：用来快速生成映射

  - 接受任意多个（包括0个和1个）序列作为参数，返回一个tuple列表

  - ```python
    x = [1, 2, 3]
    y = [4, 5, 6, 7]
    xy = zip(x, y)
    print xy
    ```

  - 运行的结果是：

    [(1, 4), (2, 5), (3, 6)]

  

  

  

  

  