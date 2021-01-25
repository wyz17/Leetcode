

# 98. Validate Binary Search Tree

### 题目

链接：https://leetcode.com/problems/validate-binary-search-tree/



### 思路1 - Recursive

#### 步骤

- 递归的方法，关键点是用min和max去存储了值，从而避免去判断是左子树还是右子树




#### 复杂度

时间：` O(logN)`

空间：` O(1)`



#### 代码

##### Java

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
```



##### Python

```python
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.isValid(root, None, None)
    
    def isValid(self, root, left, right):
        if root == None:
            return True
        if left != None and root.val <= left:
            return False
        if right != None and root.val >= right:
            return False
        return self.isValid(root.left, left, root.val) and self.isValid(root.right, root.val, right)
```



### 思路2 - Iterative

#### 步骤

- 利用栈对tree进行中序遍历
- 注意保存pre这个前面的节点



#### 复杂度

时间：` O(logN)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
```



##### Python

```python
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stk = []
        pre = None
        while stk or root != None:
            while root != None:
                stk.append(root)
                root = root.left
            root = stk.pop()
            if pre != None and root.val <= pre.val:
                return False
            pre = root
            root = root.right
        return True
```

