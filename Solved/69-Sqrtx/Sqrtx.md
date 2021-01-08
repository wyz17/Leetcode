

# 69. Sqrt(x)

### 题目

链接：https://leetcode.com/problems/sqrtx/



### 思路1 - Binary Search

#### 步骤

- 直接遍历求解就好

  



#### 复杂度

时间：` O(N)`

空间：` O(1)` 



#### 代码

##### Java

```java
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 1, right = x / 2 + 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid == x / mid) return mid;
            if(mid > x / mid) right = mid - 1;
            else{
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
        return right;
    }
}
```



##### Python

```python
class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0:
            return 0
        left = 1
        right = x // 2 + 1
        while left <= right:
            mid = left + (right - left) // 2
            if mid == x // mid:
                return mid
            if mid > x // mid:
                right = mid - 1
            else:
                if mid + 1 > x // (mid + 1):
                    return mid
                left = mid + 1
        return right
```



### 思路2 - Newton's Method

#### 步骤

- 参考这个：https://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html



###### StefanPochmann大佬解法

https://leetcode.com/problems/sqrtx/discuss/25057/3-4-short-lines-Integer-Newton-Every-Language