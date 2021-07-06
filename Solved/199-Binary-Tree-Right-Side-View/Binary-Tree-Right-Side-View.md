# 199. Binary Tree Right Side View

### 题目

- 链接：https://leetcode.com/problems/binary-tree-right-side-view/
- 题意：本质上是求出二叉树层序遍历的一种变形



### 思路1 - Recursive

#### 步骤

- 在对二叉树进行层序遍历时，修改遍历顺序，将右边的节点置先
- 在当前level等于当前列表长度时就将root.val加进数组（因为进入了树的新层级，由于顺序是右边优先，所以添加的一定是最右边节点的值）



#### 复杂度

时间： `O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }
    
    private void dfs(List<Integer> res, TreeNode root, int level) {
        if(root == null) return;
        if(res.size() == level) res.add(root.val);
        dfs(res, root.right, level + 1);
        dfs(res, root.left, level + 1);
    }
}
```



##### Python

```python
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        self.dfs(res, root, 0)
        return res
    
    def dfs(self, res, root, level):
        tmp = []
        if not root:
            return
        if len(res) == level:
            res.append(root.val)
        self.dfs(res, root.right, level + 1)
        self.dfs(res, root.left, level + 1)
```



### 思路2 - Iterative 

#### 步骤

- 层序遍历的变式




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int size = 0;

        if(root == null) return new ArrayList<>();
        else q.add(root);
        while(!q.isEmpty()) {
            size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(i == size - 1) res.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res = []
        q = []
        if root == None:
            return res
        else:
            q.append(root)
        while q:
            size = len(q)
            for i in range(0, size):
                node = q.pop(0)
                if i == size - 1:
                    res.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return res
```

