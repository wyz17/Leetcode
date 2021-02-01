

# 104. Maximum Depth of Binary Tree

### 题目

链接：https://leetcode.com/problems/maximum-depth-of-binary-tree/



### 思路1 - Recursive

#### 步骤

- 看代码就好啦，递归




#### 复杂度

时间：` O(N)`

空间：` O(N)`

#### 代码

##### Java

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```



##### Python

```python
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
```



### 思路2 - Iterative - BFS

#### 步骤

- 同中序遍历




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res++;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        q = []
        q.append(root)
        res = 0
        while q:
            size = len(q)
            for i in range(size):
                node = q.pop(0)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            res += 1
            size = len(q)
        return res
```



### 思路3 - Iterative - DFS

#### 步骤

- 参考这个https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/34195/Two-Java-Iterative-solution-DFS-and-BFS
- 有空补啦




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java

```



##### Python

```python

```

