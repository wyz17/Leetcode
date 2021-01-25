

# 96. Unique Binary Search Trees

### 题目

链接：https://leetcode.com/problems/unique-binary-search-trees/



### 思路1 - Dynamic Programming

#### 步骤

- F(i, n) = G(i-1) * G(n-i)
- 空树和只有根节点时，也为BST
- 对于一点i，当其为根节点时
- 左子树的节点的个数为 i - 1（为1,...i - 1）
  - 右子树的个数为n - i（为 i + 1,...n）
- 对一个根来说，唯一二叉树的个数为左子树结点的个数乘以右子树的个数。而根节点可以从1到n 中选择




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
```



##### Python

```python
class Solution:
    def numTrees(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1
        dp[1] = 1
        for i in range(2, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]
        return dp[n]
```



### 思路2 - Catalan Number

#### 步骤

- 设n对应的BST个数为h(n), n-1对应的个数为h(n-1)...依此类推.
  - 把1放在根节点, 2...n放在右侧, 总种类是h(1) * h(n-1)
  - 把2放在根节点, 1放在左侧, 3...n放在右侧, 总种类是h(2) * h(n-2)
  - ....
  - 把n放在根节点, 1...n-1放在左侧, 总种类是h(n-1) * h(1)

- 所以**h(n) = h(1) * h(n-1) + h(2) * h(n-2) +...+ h(n-2) * h(2) + h(n-1) * h(1)**
- **h(n)=C(2n,n)/(n+1) (n=0,1,2,...)**
- 而**C(2n,n) = 2n*(2n-1)*(2n-2)*...*(2n-n+1) / n！= 2n/n * (2n-1)/(n-1) * (2n-2)/(n-2) *...* (n+1)/1**



#### 复杂度

时间：` O(N)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public int numTrees(int n) {
        long ans = 1;
        for(int i = n + 1; i <= 2 * n; i++){
            ans = ans * i / (i - n);
        }
        int res = Integer.parseInt(String.valueOf(ans/(n+1)));
        return res;
    }
}
```



##### Python

```python
class Solution:
    def numTrees(self, n: int) -> int:
        return int(math.factorial(2*n)/(math.factorial(n)*math.factorial(n+1)))
```

