

# 111. Minimum Depth of Binary Tree

### 题目

链接：https://leetcode.com/problems/minimum-depth-of-binary-tree/



### 思路1 - Recursive

#### 步骤

- 递归调用傻瓜解法
- 注意审题




#### 复杂度

时间：` O(NlogN)`

空间：` O(logN)` 



#### 代码

##### Java

```java
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.right);
        int right = minDepth(root.left);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left, right) + 1;
    }
}
```



##### Python

```python
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        return left + right + 1 if left == 0 or right == 0 else min(left, right) + 1
```



### 思路2 - Iterative

#### 步骤

- level order traversal
- 有空补




#### 复杂度

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java

```



##### Python

```python

```

