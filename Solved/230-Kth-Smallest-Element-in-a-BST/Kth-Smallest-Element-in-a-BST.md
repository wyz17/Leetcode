

# 230. Kth Smallest Element in a BST

### 题目

- 链接：https://leetcode.com/problems/kth-smallest-element-in-a-bst/

- 题意：判断一棵树中第k大小的值



### 思路1 - Recursive 

#### 步骤

- 使用count记录下当前的输出的节点顺序
- 左边遍历输出一个节点就count--



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    private static int res = 0;
    private static int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        // traverse left sub tree
      if (root.left != null) {
          helper(root.left);
      }
      count--;
      if (count == 0) {
          res = root.val;
          return;
      }
        // traverse right sub tree
      if(root.right != null) {
          helper(root.right);
      }
  }
}
```



##### Python

```python
class Solution:
    count = 0
    res = 0
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.count = k
        self.dfs(root)
        return self.res
    
    def dfs(self, root):
        if root.left:
            self.dfs(root.left)
        self.count -= 1
        if self.count == 0:
            self.res = root.val
            return
        if root.right:
            self.dfs(root.right)
```



### 思路2 - Iterative

#### 步骤

- 通过栈进行中序遍历，同时记录下节点数



#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root != null) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            } else {
                TreeNode cur = stk.pop();
                k--;
                if( k == 0) return cur.val;
                root = cur.right;
            }
        }
        return -1;
    }
}
```



##### Python

```python
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stk = []
        while stk or root:
            if root:
                stk.append(root)
                root = root.left
            else:
                cur = stk.pop()
                k -= 1
                if k == 0:
                    return cur.val
                root = cur.right
```

