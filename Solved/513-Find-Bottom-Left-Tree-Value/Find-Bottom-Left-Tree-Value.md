# 513. Find Bottom Left Tree Value

### 题目

- 链接：https://leetcode.com/problems/find-bottom-left-tree-value/
- 题意：求出二叉树最底端 & 最左端的值



### 思路1 - DFS

#### 步骤

- 维护当前深度`depth` 和 已经遍历过的最大深度`count`
- 当前深度`depth`大于已遍历过的最大深度`count`时，考虑更新结果值
- 保证先遍历左子树，再遍历右子树，保证每次遍历的第一个`depth > count`的结点都是深度为`depth`层的最左边结点



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    int depth = 1;
    int res = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        res = root.val;
        dfs(root, depth);
        return res; 
    }
    
    private void dfs(TreeNode root, int count) {
        if(root == null) return;
        if(count > depth) {
            res = root.val;
            depth = count;
        }
        if (root.left != null) {
            dfs(root.left, count + 1);
        }
        if (root.right != null) {
            dfs(root.right, count + 1);
        }
    }
}
```



##### Python

```python
class Solution:
    depth = 1
    res = 0
    
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if root == None:
            return 0;
        self.res = root.val
        self.dfs(root, self.depth)
        return self.res
    
    def dfs(self, root, count):
        if root == None:
            return
        if count > self.depth:
            self.res = root.val
            self.depth = count
        if root.left:
            self.dfs(root.left, count + 1)
        if root.right:
            self.dfs(root.right, count + 1)
```





### 思路2 - BFS

#### 步骤

- 使用队列，层序遍历
- 每次循环每一层，记录每一层的最左边结点，最后返回的即为最底下一层的最左边结点



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    int res = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        res = root.val;
        bfs(root);
        return res; 
    }
    
    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int n = q.size();
            res = q.peek().val;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
    }
}
```



##### Python

```python
class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        # 新开一个list名为queue
        queue = [root]
        for node in queue:
            # 把这棵树的子节点从右往左往里添加，最后得到的那个node即为最深且最左的叶节点
            queue += filter(None, (node.right, node.left))
        return node.val
```

