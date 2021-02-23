

# 109. Pascal's Triangle II

### 题目

链接：https://leetcode.com/problems/pascals-triangle-ii/



### 思路 - Dynamic Programming

#### 步骤

- 分配第K行的空间，重复利用这个的空间并存放在其中
- 再利用上下行之间的计算关系，计算出第K行所有元素。



#### 复杂度

时间：` O(numRows^2)`

空间：` O(numRows)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for(int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1)); 
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1] + [0] * rowIndex
        for i in range(rowIndex):
            res[0] = 1
            for j in range(i+1, 0, -1):
                res[j] = res[j] + res[j-1]
        return res
```



### 思路 - Math

#### 步骤

- 杨辉三角以正整数构成，数字左右对称，每行由1开始逐渐变大，然后变小，回到1。
- 第![n](http://upload.wikimedia.org/math/7/b/8/7b8b965ad4bca0e41ab51de7b31363a1.png)行的数字个数为![n](http://upload.wikimedia.org/math/7/b/8/7b8b965ad4bca0e41ab51de7b31363a1.png)个。
- 第![n](http://upload.wikimedia.org/math/7/b/8/7b8b965ad4bca0e41ab51de7b31363a1.png)行的第![k](http://upload.wikimedia.org/math/8/c/e/8ce4b16b22b58894aa86c421e8759df3.png)个数字为组合数 ![C_{n-1}^{k-1}](http://upload.wikimedia.org/math/7/c/9/7c90e60eb2d8eaec74a30a81b1b4f1d9.png)。
- 第![n](http://upload.wikimedia.org/math/7/b/8/7b8b965ad4bca0e41ab51de7b31363a1.png)行数字和为 ![2^{n-1}](http://upload.wikimedia.org/math/4/2/e/42ef218254478d61d6f2afb986f4b88c.png)。
- 除每行最左侧与最右侧的数字以外，每个数字等于它的左上方与右上方两个数字之和（也就是说，第![n](http://upload.wikimedia.org/math/7/b/8/7b8b965ad4bca0e41ab51de7b31363a1.png)行第![k](http://upload.wikimedia.org/math/8/c/e/8ce4b16b22b58894aa86c421e8759df3.png)个数字等于第 ![n-1](http://upload.wikimedia.org/math/a/4/3/a438673491daae8148eae77373b6a467.png) 行的第 ![k-1](http://upload.wikimedia.org/math/1/4/4/14464ac1dfe6fa8ad8fda94bb6f01571.png) 个数字与第![k](http://upload.wikimedia.org/math/8/c/e/8ce4b16b22b58894aa86c421e8759df3.png)个数字的和）。这是因为有组合恒等式：![C_{n}^{i}=C_{n-1}^{i-1}+C_{n-1}^{i}](http://upload.wikimedia.org/math/c/7/0/c702e84dfa4142f435d9c2bbbbfeeae0.png)。可用此性质写出整个杨辉三角形。
- 帕斯卡三角形的第n行第m个元素是 C(n, m) = n!/(m! * (n-m)!)。所以 C(n, m-1) = n!/((m-1)! * (n-m+1)!)，所以 C(n, m) = C(n, m-1) * (n-m+1) / m。另外，有组合数的性质可以减少一半计算量：C(n, m) == C(n, n-m)。



#### 复杂度

时间：` O(numRows)`

空间：` O(numRows)`



#### 代码

##### Python

```python
class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1] * (rowIndex + 1)
        for i in range(1, rowIndex // 2 + 1):
            res[i] = res[rowIndex - i] = res[i - 1] * (rowIndex - i + 1) // i
        return res
```



