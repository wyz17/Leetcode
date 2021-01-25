

# 101. Symmetric Tree

### 题目

链接：https://leetcode.com/problems/symmetric-tree/



### 思路1 - Recursive

#### 步骤

- 看代码就好啦，递归的思路是




#### 复杂度

时间：` O(N)`

空间：` O(N)`，The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in *O*(*n*). Therefore, space complexity due to recursive calls on the stack is *O*(*n*) in the worst case. 

#### 代码

##### Java

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
```



##### Python

```python
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.isMirror(root, root)
    
    def isMirror(self, t1, t2):
        if not t1 and not t2:
            return True
        if not t1 or not t2:
            return False
        return t1.val == t2.val and self.isMirror(t1.left, t2.right) and self.isMirror(t1.right, t2.left)
```



### 思路2 - Iterative 

#### 步骤

- 使用两个队列，分别代表根节点的左右孩子作为根的树，判断这两个队列是否对称（没必要两个）
- 用一个队列 / 栈，每次存四个弹出两个，注意一下存入顺序就好




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
```



##### Python

```python
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        q = []
        q.append(root)
        q.append(root)
        while q:
            t1 = q.pop()
            t2 = q.pop()
            if not t1 and not t2:
                continue
            if not t1 or not t2:
                return False
            if t1.val != t2.val:
                return False
            q.append(t1.left)
            q.append(t2.right)
            q.append(t2.left)
            q.append(t1.right)
        return True
```

