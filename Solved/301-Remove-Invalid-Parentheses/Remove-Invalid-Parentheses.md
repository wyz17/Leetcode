# 301. Remove Invalid Parentheses

### 题目

- 链接：https://leetcode.com/problems/remove-invalid-parentheses/





### 思路 - DFS

#### 步骤 - Java

- 先扫描s，确认最少需要删除多少个左括号和右括号，记为left和right
- 从左到右对字符串进行遍历，通过open记录字符串是否合法（如果open  <  0 就是存在不合法字符串）
- 如果遍历到左括号
  - 删除左括号
  - 不删除左括号：open + 1
- 如果遍历到右括号
  - 删除右括号
  - 不删除右括号：open - 1
- 每一步需要检查的内容
  - i 不会超过字符串的长度
  - r，l，open都不可能是负数
  - 用HashSet存储可以避免重复值



#### 复杂度

时间： `O(n*2^n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int r = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else if (s.charAt(i) == ')') {
                if (l != 0) l--;
                else r++;
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, res, new StringBuilder(), l, r, 0, 0);
        return new ArrayList<String>(res);
    }
    
    private void dfs(String s, Set<String> res, StringBuilder sb, int l, int r, int i, int open) {
        if(l < 0 || r < 0 || open < 0) return;
        if (i == s.length()) {
            if (l == 0 && r == 0 && open == 0) res.add(sb.toString());
            return;
        }
        
        char c = s.charAt(i);
        int len = sb.length();
        
        if (c == '(') {
            dfs(s, res, sb, l - 1, r, i + 1, open); // not use (
            dfs(s, res, sb.append(c), l, r, i + 1, open + 1);   // use (
        } else if (c == ')') {
            dfs(s, res, sb, l, r - 1, i + 1, open); // not use  )
            dfs(s, res, sb.append(c), l, r, i + 1, open - 1);   // use )
        } else {
            dfs(s, res, sb.append(c), l, r, i + 1, open);
        }
        sb.setLength(len);
    }
}
```





#### 步骤 - Python

- 先扫描s，确认最少需要删除多少个左括号和右括号，记为left和right
- 然后DFS，对每一个括号都看一下，如果将其干掉，是否可行？
- DFS函数的套路是：
  - 先是退出判断：left和right都为0，且字符串合法
  - 然后从上一次处理的位置开始遍历
  - 如果是括号
    - 如果与前一个字符相同，跳过
    - 因为这会造成重复结果，所以跳过是个优化
  - 如果是左括号，且left > 0，则干掉该括号，然后递归DFS，参数中left--
  - 如果是右括号，且right > 0，则干掉该括号，然后递归DFS，参数中right--
- 没有重复括号判断也可以工作，只是效率低



#### 复杂度

时间： `O(?)`

空间：` O(?)`



##### Python

```python
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        l, r = 0, 0
        for c in s:
            if c == '(': l += 1
            elif c == ')': 
                if l == 0: r += 1
                else: l -= 1
        res = []
        self.dfs(res, s, l, r, 0)
        return res
    
    def dfs(self, res, s, l, r, start):
        if l == 0 and r == 0:
            if self.valid(s):
                res.append(s)
            return 
        for i in range(start, len(s)):
            if i != start and s[i] == s[i - 1]: continue
            if r > 0 and s[i]==')': self.dfs(res, s[:i] + s[i + 1:], l, r - 1, i)
            if l > 0 and s[i]=='(': self.dfs(res, s[:i] + s[i + 1:], l - 1, r, i)
        
        
    def valid(self, s):
        #从左向右遍历valid字符串，左括号的数量只可能小于等于右括号的数量，字符串结束时，必两者相等
        left = 0
        for c in s:
            if c == '(': left += 1
            elif c == ')': left -= 1
            if left < 0: return False
        return left == 0
```

