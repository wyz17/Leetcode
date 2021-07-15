# 131. Palindrome Partitioning

### 题目

- 链接：https://leetcode.com/problems/sudoku-solver/
- 题意：返回所有子分区是回文串的列表



### 思路 - DFS

#### 步骤

- DFS递归



#### 复杂度

时间： `O(N * 2^N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> path, String s) {
        if(s == null || s.length() == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 1; i < s.length() + 1; i++) {
            String tmp = s.substring(0, i);
            if(!isPalindrome(tmp)) continue;
            
            path.add(tmp); 
            dfs(res, path, s.substring(i, s.length()));
            path.remove(path.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
```



##### Python

```python
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        self.dfs(res, [], s)
        return res
    
    def dfs(self, res, path, s):
        if not s or len(s) == 0:
            res.append(path)
            return;
        for i in range(1, len(s) + 1):
            tmp = s[0: i]
            if not self.isPalindrome(tmp): continue; 
            self.dfs(res, path + [tmp], s[i:])
            
    
    def isPalindrome(self, s):
        l, r = 0, len(s) - 1
        while l <= r:
            if s[l] != s[r]:
                return False
            r -= 1
            l += 1
        return True
```

