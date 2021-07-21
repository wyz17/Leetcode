# Lint-570. Find the Missing Number II

### 题目

- 链接：https://www.lintcode.com/problem/570/description
- 题意：给出大小为n的数，给出一个字符串，判断字符串中缺失了哪一个数字



### 思路 - DFS

#### 步骤

- dfs递归遍历
- 使用一个boolean数组记录第n个数字是否被访问
- 使用start记录遍历到字符串的什么位置，当start等于字符串长度时，说明遍历完毕，可以去寻找missing数字了
- 注意点
  - 数字可能是1位也可能是2位，dfs遍历的时候需要同时取1位和2位进行判断
  - 2位数字判断的时候注意边界条件的处理：是否在n的范围内；是否已存在；是否会超出字符串长度
- 减枝
  - 当发现missing更新，不用继续调用递归，直接return就好
  - 如果字符串的第一个字符为0，肯定不合法，直接返回就好
  - 当start等于字符串长度时，不管找没找到missing，都直接返回



#### 复杂度

时间： `O(C(N, len))`，C表示组合数，n是多少个数字，len是字符串长度，但因为有很多剪枝，状态量要远远低于这个`C(N, len)`

空间：` O(N)`



#### 代码

##### Java

```java
public class Solution {
    
    private int missing;
    public int findMissing2(int n, String str) {
        missing = -1;
        boolean[] visited = new boolean[n + 1];
        dfs(n, str, 0, visited);
        return missing;
    }
    
    private void dfs(int n, String str, int start, boolean[] visited) {
        if (missing != -1) return;
        if (start == str.length()) {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    missing = i;
                    return;
                }
            }
            return;
        }
        
        if (str.charAt(start) == '0') return;
        
        for (int ch = 1; ch <= 2 && start + ch <= str.length(); ch++) {
            int num = Integer.parseInt(str.substring(start, start + ch));
            if (num > 0 && num <= n && !visited[num]) {
                visited[num] = true;
                dfs(n, str, start + ch, visited);
                visited[num] = false;
            }
        }
        return;
    }
}
```



##### Python

```python
class Solution:
    """
    @param n: An integer
    @param s: a string with number from 1-n in random order and miss one number
    @return: An integer
    """
    missing = -1
    def findMissing2(self, n, s):
        visited = [False] * (n + 1)
        self.dfs(n, s, 0, visited)
        return self.missing
    
    def dfs(self, n, s, start, visited):
        if self.missing != -1: return
        if start == len(s):
            for i in range(1, n + 1):
                if not visited[i]:
                    self.missing = i
                    return
            return
        
        if s[start] == '0': return

        for ch in range(1, 3):
            if start + ch >len(s): return
            num = int(s[start : start + ch])
            if num > 0 and num <= n and not visited[num]:
                visited[num] = True
                self.dfs(n, s, start + ch, visited)
                visited[num] = False
        return
```