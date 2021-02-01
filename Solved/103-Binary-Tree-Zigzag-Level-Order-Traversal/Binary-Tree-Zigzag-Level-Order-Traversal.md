

# 103. Binary Tree Zigzag Level Order Traversal

### 题目

链接：https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/



### 思路1 - Recursive 

#### 步骤

- 通过一个level参数，来确定当前的递归层是对哪个层的节点进行遍历。
- 需要注意的是，在层数参数level等于当前res所保存的层的个数时，需要加入新的层。也即，res中存储每一层的节点的数组个数，要时刻比当前遍历的层多1。
  - zigzag的区别就在于何时插入当前节点
  - 可以根据当前level的奇偶性去判断是插入在第一位还是最后一位




#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;
        if(res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        if(level % 2 == 0) {
            res.get(level).add(root.val);
        } else {
            res.get(level).add(0, root.val);
        }
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }
}
```



##### Python

```python
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.dfs(res, root, 0)
        return res
    
    def dfs(self, res, root, level):
        if not root:
            return;
        if len(res) < level + 1:
            res.append([])
        if level % 2 == 0:
            res[level].append(root.val)
        else:
            res[level].insert(0, root.val)
        self.dfs(res, root.left, level + 1)
        self.dfs(res, root.right, level + 1)
```



### 思路2 - Iterative 

#### 步骤

- 利用队列先进先出的特性
- 从根节点开始push进队列
- 然后存当前节点的左节点和右节点
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int len = 0;

        if(root == null) return new ArrayList<>();
        else q.add(root);
        boolean level = false;
        while(!q.isEmpty()) {
            tmp = new ArrayList<>();
            len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode t = q.poll();
                if(t != null) {
                    if(level) tmp.add(t.val);
                    else tmp.add(0, t.val);
                    if(t.right != null) q.add(t.right);
                    if(t.left != null) q.add(t.left);
                }
            }
            res.add(tmp);
            level = !level;
            len = q.size();
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        tmp = []
        q = []
        if root == None:
            return res
        else:
            q.append(root)
        level = False
        while q:
            tmp = []
            size = len(q)
            for i in range(0, size):
                node = q.pop(0)
                if node:
                    if not level:
                        tmp.append(node.val)
                    else:
                        tmp.insert(0, node.val)
                    q.append(node.left)
                    q.append(node.right)
            if tmp:
                res.append(tmp)
                level = not level
            size = len(q)
        return res
```

