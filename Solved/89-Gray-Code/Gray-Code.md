

# 89. Gray Code



### 题目

链接：https://leetcode.com/problems/gray-code/

有空补充！



### 思路

#### 步骤

- ```
  n = 0: 0
  n = 1: 0 | 1
  n = 2: 00, 01 | 11, 10
  n = 3: 000, 001, 011, 010 | 110, 111, 101, 100
  f(n) = f(n - 1) | 2 ^ (n - 1) + f(n - 1)
  ```



#### 复杂度

时间：` O(N^2)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for(int i = 1; i <= n; i++) {
            int size = res.size();
            int base = 1 << (i - 1);
            for(int j = size - 1; j >= 0; j--) {
                res.add(base + res.get(j));
            }
        }
        return res;
    }
}
```



##### Python

```python
None
```

