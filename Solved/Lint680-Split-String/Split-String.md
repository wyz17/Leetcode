# Lint-680. Split String

### 题目

- 链接：https://www.lintcode.com/problem/680/solution
- 题意：将给出的字符串分割为包含1或2个连续字符的数组，返回所有结果的集合



### 思路 - DFS

#### 步骤

- dfs递归遍历



#### 复杂度

时间： `O(2^N)`

空间：` O(N)`



#### 代码

##### Java

```java
public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, String s, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 1; i <= 2; i++) {
            if(start + i <= s.length()) {
                path.add(s.substring(start, start + i));
                dfs(res, path, s, start + i);
                path.remove(path.size() - 1);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    """
    @param: : a string to be split
    @return: all possible split string array
    """

    def splitString(self, s):
        res = []
        self.dfs(res, s, [])
        return res

    def dfs(self, res, s, path,):
        if s == '':
            res.append(path)
            return
        for i in range(2):
            if i + 1 <= len(s):
                self.dfs(res, s[i+1:], path + [s[:i+1]])
```

