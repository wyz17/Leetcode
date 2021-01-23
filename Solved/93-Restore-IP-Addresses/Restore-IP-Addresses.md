

# 93. Restore IP Addresses

### 题目

链接：https://leetcode.com/problems/restore-ip-addresses/



### 思路1 - DFS

#### 步骤

- 递归遍历

- 注意一下遇到0的情况

  

#### 复杂度

时间：` O(？)`

空间：` O(？)`



#### 代码

##### Java

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        dfs(res, "", s, 0);
        return res;
    }
    
    private void dfs(List<String> res, String tmp, String s, int k) {
        if (s.isEmpty() || k == 4) {
            if(s.isEmpty() && k == 4)
                res.add(tmp.substring(1));
            return;
        }
        for(int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String part = s.substring(0, i);
            if(Integer.valueOf(part) <= 255) {
                dfs(res, tmp + "." + part, s.substring(i), k + 1);
            }
        } 
    }
}
```



##### Python

```python
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        self.dfs(res, "", s, 0)
        return res
    
    def dfs(self, res, tmp, s, count):
        if count > 4:
            return
        if count == 4 and not s:
            res.append(tmp[1:])
            return
        
        for i in range(1, len(s) + 1):
            if s[:i] == '0' or (s[0] != '0' and 0 < int(s[:i]) < 256):
                self.dfs(res, tmp + '.' + s[:i], s[i:], count + 1)
```



### 思路2 - 大佬解法

#### 步骤

- 不多说 看代码 牛逼

  

#### 复杂度

时间：` O(1)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        StringBuffer ip = new StringBuffer();
        
        for(int a = 1; a <= 3; a++)
        for(int b = 1; b <= 3; b++)
        for(int c = 1; c <= 3; c++) {
            int d = len - a - b - c;
            if(d > 0 && d <= 3 && a + b + c + d == len) {
                int A = Integer.valueOf(s.substring(0, a));
                int B = Integer.valueOf(s.substring(a, a + b));
                int C = Integer.valueOf(s.substring(a + b, a + b + c));
                int D = Integer.valueOf(s.substring(a + b + c));
                if(A <= 255 && B <= 255 && C <= 255 && D <= 255) {
                    ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                    if(ip.length() == len + 3){  //判断存在连续0的情况，因为连续0会被parse成一个0
                        res.add(ip.toString());
                    }
                    ip = new StringBuffer();
                }
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        for a in range(1, 5):
            for b in range(1, 5):
                for c in range(1, 5):
                    d = len(s) - a - b - c
                    if d > 0 and d <= 3:
                        A = int(s[0:a])
                        B = int(s[a:a+b])
                        C = int(s[a+b:a+b+c])
                        D = int(s[a+b+c:])
                        if A <= 255 and B <= 255 and C <= 255 and D <= 255:
                            tmp = '%s%s%s%s%s%s%s' % (A, '.', B, '.', C, '.', D)
                            if len(tmp) == len(s) + 3:
                                res.append(tmp)
        return res
```

