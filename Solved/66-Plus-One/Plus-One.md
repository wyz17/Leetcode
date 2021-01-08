

# 66. Plus One

### 题目

链接：https://leetcode.com/problems/plus-one/



### 思路

#### 步骤

- 傻瓜解法

  



#### 复杂度

时间：` O(N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
```



##### Python

```python
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] < 9:
                digits[i] = digits[i] + 1
                return digits
            digits[i] = 0
        return [1] + digits
```
