

# 43. Multiply Strings

### 题目

链接：https://leetcode.com/problems/multiply-strings/



### 思路

#### 步骤

- 模拟我们做乘法时的步骤
- 用一个数组存储每一位数相乘
- 注意加和超出10的情况就好
- （最开始没有用列表存位数，直接用res+=的方法，结果overflow了  T.T ） 



#### 复杂度

时间：` O(m x n)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
			return "0";
        
        int[] res = new int[num1.length() + num2.length() + 1];
        for(int i = num2.length() - 1; i >= 0; i--) {
            for(int j = num1.length() - 1; j >= 0; j--) {
                int mul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                res[i + j + 1] += mul;
                if(res[i + j + 1] >= 10){
                    res[i + j] += res[i + j + 1] / 10;
                    res[i + j + 1] = res[i + j + 1] % 10;
                }
            }
        }
        
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < res.length - 1; i++) {
            sb.append(res[i]);
        }
        
        return sb.toString().charAt(0) == '0' ? sb.toString().substring(1): sb.toString() ;
    }
}
```



##### Python

```python
class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n, m = len(num1), len(num2)
        if not n or not m:
            return "0"
        
        result = [0] * (n + m)
        for i in reversed(range(n)):
            for j in reversed(range(m)):
                current = int(result[i + j + 1]) + int(num1[i]) * int(num2[j])
                result[i + j + 1] = current % 10
                result[i + j] += current // 10
        
        for i, c in enumerate(result):
            if c != 0:
                return "".join(map(str, result[i:]))
        
        return "0"
```


