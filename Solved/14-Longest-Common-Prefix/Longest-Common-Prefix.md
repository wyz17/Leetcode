# 14. Longest Common Prefix

### 题目

链接：https://leetcode.com/problems/longest-common-prefix/



### 思路 - 暴力解法

#### 步骤

- 双重循环遍历



#### 复杂度

时间：

空间：



#### 代码

##### Java

``` python
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = new String();
        for(int j = 0; j < strs[0].length(); j++){
            char c = strs[0].charAt(j);
            for(int i = 1; i < strs.length; i++){
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        shortest = min(strs, key=len)
        for i, ch in enumerate(shortest):
            for other in strs:
                if other[i] != ch:
                    return shortest[:i]
        return shortest
```

