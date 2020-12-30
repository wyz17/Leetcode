

# 50. Pow(x, n)

### 题目

链接：https://leetcode.com/problems/powx-n/



### 思路

#### 步骤

- 每次将循环折半去搜索



#### 复杂度

时间：` O(logN)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        boolean flg = true;
        if(n < 0) flg = false;
        while(n != 0) {
            if(n % 2 != 0) res *= x;
            x *= x;
            n /= 2;
        }
        return flg ? res : 1 / res;
    }
}

//优化一下
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2) {
            if(i % 2 != 0) res *= x;
            x *= x;
        }
        return n > 0 ? res : 1 / res;
    }
}
```



##### Python

```python
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            x = 1 / x
            n = -n
        ans = 1
        res = 1
        while n:
            if n % 2:
                ans *= x
            n >>= 1
            x *= x
        return ans
```

参考大佬解法：时间复杂度是O(1)，空间复杂度是O(1) -> 我认为这个代码是O(1)，因为n只有32位，循环次数是有上限的常数。
