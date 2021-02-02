

# 107. Binary Tree Level Order Traversal II

### 题目

链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

思路和 [Binary Tree Level Order Traversal](../102-Binary-Tree-Level-Order-Traversal/Binary-Tree-Level-Order-Traversal.md) 一样。



### 思路1 - Recursive

#### 步骤

- 通过一个level参数，来确定当前的递归层是对哪个层的节点进行遍历。
- 需要注意的是，在层数参数level等于当前res所保存的层的个数时，需要加入新的层。也即，res中存储每一层的节点的数组个数，要时刻比当前遍历的层多1。




#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(res.size() < level + 1) {
            res.add(0, new ArrayList());
        }
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}
```



##### Python

```python
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.dfs(res, root, 0)
        return res
    
    def dfs(self, res, root, level):
        if not root:
            return
        if len(res) < level + 1:
            res.append([])
        self.dfs(res, root.left, level + 1)
        self.dfs(res, root.right, level + 1)
        res[len(res) - level - 1].append(root.val)
```



### 思路2 - Iterative

#### 步骤

- 这里应该用一个双端队列，根据当前节点层数判断是哪端进哪端出
- 从根节点开始push进队列
- 然后存当前节点的左节点和右节点（这里需要判断按照什么顺序存入左节点和右节点）
- 同时将上面的左节点和右节点也加入队列
- 这里麻烦一点的地方是要将树分层输出为list
  - 可以在每一层用一个for循环遍历queue中的值，存入list
  - 这个就是当前层包含的节点数
  - 加循环的时候一定要注意判断队列的长度，不能直接写进循环里，而是要另外用一个int去更新！




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        List<Integer> tmp;
        int len;
        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);
        while(!q.isEmpty()) {
            tmp = new ArrayList<>();
            len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(node != null) {
                    tmp.add(node.val);
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
            res.add(0, tmp);
            len = q.size();
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = []
        q.append(root)
        while q:
            tmp = []
            size = len(q)
            for i in range(0, size):
                node = q.pop(0)
                if node:
                    tmp.append(node.val)
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
            if tmp:
                res.insert(0, tmp)
            size = len(q)
        return res
```

