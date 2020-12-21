

# 38. Count and Say

### 题目

链接：https://leetcode.com/problems/count-and-say/

难点在于看题目...



题意：

- n=1时输出字符串1
- n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11
- n=3时，由于上次字符是11，有2个1，所以输出21
- n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211
- 依次类推，写个countAndSay(n)函数返回字符串



### 思路1 - 递归

#### 步骤

- 递归遍历就好



#### 复杂度

时间：` O(1)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = countAndSay(n - 1);
        
        StringBuffer res = new StringBuffer("");
        char c = '0';
        int count = 1;
        for (int i = 0;i < str.length(); i++){
            c = str.charAt(i);
            count = 1;
            while((i + 1) < str.length() && str.charAt(i+1) == c){
                count++;
                i++;
            }
            res.append(count + "" + c);
        }
        return res.toString();
    }
}
```



##### Python

```python
class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return "1"
        
        s = self.countAndSay(n - 1)
        
        res = ""
        i = 0
        while i < len(s):
            count = 1
            while i + 1 < len(s) and s[i] == s[i+1]:
                count = count + 1
                i = i + 1
            res = '%s%s%s' % (res, count, s[i])
            i = i + 1
        return res   
```


