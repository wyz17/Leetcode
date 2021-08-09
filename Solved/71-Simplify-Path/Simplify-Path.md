

# 71. Simplify Path

### 题目

链接：https://leetcode.com/problems/simplify-path/



### 思路1 - Stack

#### 步骤

- 栈比较好理解，处理好何时出栈入栈就好
- 这里注意最后调接口将stack转为list



#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    // faster
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!dir.equals(".") && !dir.equals("") && !dir.equals("..")) stack.push(dir);
        }
        StringBuffer res = new StringBuffer("");
        for (String dir : stack) {
            res.insert(0, dir);
            res.insert(0, "/");
        }
        return res.toString().equals("") ? "/" : res.toString();
    }  
    
    public String simplifyPath2(String path) {
        Stack<String> stk = new Stack<String>();
        String[] p = path.split("\\/+");
        if(p.length == 0) return "/";
        p[0] = ".";
        for(String i : p) {
            if(!i.equals(".") && !i.equals(".."))
                stk.push(i);
            if(!stk.isEmpty() && i.equals("..") && !i.equals("") )
                stk.pop();
        }
        List<String> list = new ArrayList(stk);
        return "/" + String.join("/", list);
    }
}
```



##### Python

```python
class Solution:
    def simplifyPath(self, path: str) -> str:
        p = path.split("/")
        stk = []
        for i in p:
            if i != "." and i != ".." and i != "":
                stk.append(i)
            if len(stk) != 0 and i == "..":
                stk.pop()
        return '/' + '/'.join(stk)
```

