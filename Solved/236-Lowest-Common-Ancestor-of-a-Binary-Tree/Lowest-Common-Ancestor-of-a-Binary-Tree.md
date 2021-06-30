

# 236. Lowest Common Ancestor of a Binary Tree

### 题目

- 链接：https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

- 题意：判断最低的共同祖先节点



### 思路 - Recursive 

#### 步骤

- 如果p和q同时存在于根节点为root的树中，那么就返回他们的LCA
- 如果p和q都不存在于根节点为root的树中，返回空
- 如果p或者q存在于根节点为root的树中，返回存在的那个节点



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
```



##### Python

```python
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or q == root or p == root:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        return right if right else left
```


