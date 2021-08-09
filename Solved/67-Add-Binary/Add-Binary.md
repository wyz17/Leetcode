

# 67. Add Binary

### 题目

链接：https://leetcode.com/problems/add-binary/



### 思路

#### 步骤

- 直接遍历求解就好

  



#### 复杂度

时间：` O(N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(j >= 0) sum += b.charAt(j--) - '0';
            if(i >= 0) sum += a.charAt(i--) - '0';
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) res.append(carry); //最后一位的进位
        return res.reverse().toString();
    }
}
```



##### Python

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = 0
        result = ''

        a = list(a)
        b = list(b)

        while a or b or carry:
            if a:
                carry += int(a.pop())
            if b:
                carry += int(b.pop())

            result += str(carry %2)
            carry //= 2

        return result[::-1]
    
    def addBinary2(self, a: str, b: str) -> str:
        #int(a,2) -> turn a into int format
        #bin(int(a,2) + int(b,2)) -> turn a + b into binary format
        #[2:] -> remove start '0b'
        return str(bin(int(a,2) + int(b,2)))[2:]
            
```

