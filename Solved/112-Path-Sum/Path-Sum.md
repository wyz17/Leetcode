

# 112. Path Sum

### 题目

链接：https://leetcode.com/problems/path-sum/



### 思路1 - Recursive

#### 步骤

- 递




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
    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:
        if not root:
            return False
        if not root.left and not root.right and targetSum - root.val == 0:
            return True
        return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right, targetSum - root.val)
```



### 思路2 - Iterative

#### 步骤

- Post order traversal
- 有空补
- https://leetcode.com/problems/path-sum/discuss/36382/Accepted-By-using-postorder-traversal




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

