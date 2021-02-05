

# 110. Balanced Binary Tree

### 题目

链接：https://leetcode.com/problems/balanced-binary-tree/



### 思路1 - Recursive

#### 步骤

- 判断二叉树是否平衡：高度平衡二叉树是每一个结点的两个子树的深度差不能超过1
- 求出各个点深度的函数，然后对每个节点的两个子树来比较深度差，递归调用




#### 复杂度

时间：` O(NlogN)`

空间：` O(logN)` 



#### 代码

##### Java

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getLength(root.left, 0) - getLength(root.right, 0)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getLength(TreeNode node, int level) {
        if(node == null) return level;
        return Math.max(getLength(node.left, level + 1), getLength(node.right, level + 1));
    }
}
```



##### Python

```python
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        if abs(self.getDepth(root.left, 0) - self.getDepth(root.right, 0)) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
        
    def getDepth(self, root, level):
        if not root:
            return level
        return max(self.getDepth(root.left, level + 1), self.getDepth(root.right, level + 1))
```



### 思路2 - 优化

#### 步骤

- 方法一不够高效，因为每一个点都会被上面的点计算深度时访问一次，所以这里进行优化。
- 如果发现子树不平衡，就不计算具体的深度，而是直接返回-1
- 对于每一个节点，递归获得左右子树的深度
  - 如果子树是平衡的，则返回真实的深度，
  - 如果不平衡，直接返回-1




#### 复杂度

时间：` O(N)`

空间：` O(H)`



#### 代码

##### Java

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getLength(root) != -1;
    }
    
    private int getLength(TreeNode node) {
        if(node == null) return 0;
        int left = getLength(node.left);
        int right = getLength(node.right);
        if(left == -1 || right == -1 || Math.abs(right - left) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
```



##### Python

```python
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.getDepth(root) != -1
        
    def getDepth(self, root):
        if not root:
            return 0
        left = self.getDepth(root.left)
        right = self.getDepth(root.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        return max(left, right) + 1
```

