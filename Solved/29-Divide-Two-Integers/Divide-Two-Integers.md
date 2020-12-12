

# 29. Divide Two Integers

### 题目

链接：https://leetcode.com/problems/divide-two-integers/



### 思路

#### 步骤

- 这个不能傻瓜了
- 这个边角case真是令人窒息
- 不想写



#### 复杂度

时间：` O(n)`

空间：` O(1)`



#### 代码

##### Java

```java

```



##### Python

```python

```



### 思路2 - 超时了

#### 步骤

- 将除法转化为减法



#### 复杂度

时间：` O(dividend/divisor)`

空间：` O(1)`



#### 代码

##### Python

```python
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if divisor == 0:
            return 0
        res = 0
        minint = -sys.maxsize
        maxint = sys.maxsize - 1
        if (divisor > 0 and dividend > 0) or (divisor < 0 and dividend < 0):
            flg = True
        else:
            flg = False
            
        dividend = abs(dividend)
        divisor = abs(divisor)
        while dividend > 0:
            dividend -= divisor
            if dividend < 0:
                break
            res = res + 1
        if res > maxint or res < minint:
            return maxint
        else:
            return res if flg == True else 0 - res
```



## Python知识点

### Python三元表达式

三元表达式

res='zuo' if x > y else 'you'

如果条件成立返回zuo 不成立返回you 中间是条件判断这就是三元表达式

```python
 return res if flg == True else 0 - res
```

