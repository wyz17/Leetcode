# 257. Binary Tree Paths

### 题目

- 链接：https://leetcode.com/problems/binary-tree-paths/
- 题意：打印出二叉树的所有路径



### 思路 - Recursive + DFS

#### 步骤

- dfs递归遍历
- 注意root为空的处理方式
- 注意一下字符串的拼接





#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        dfs(res, "", root);
        return res;
    }
    
    private void dfs(List<String> res, String s, TreeNode root) {
        s += root.val;
        if(root.left == null && root.right == null) res.add(s);
        if(root.left != null) dfs(res, s + "->", root.left);
        if(root.right != null) dfs(res, s + "->", root.right);
    }
}
```



##### Python

```python
class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []
        if not root: return res
        self.dfs(res, root, "")
        return res
    
    def dfs(self, res, root, s):
        s += str(root.val)
        if root.left:
            self.dfs(res, root.left, s + "->")
        if root.right:
            self.dfs(res, root.right, s + "->")
        if not root.left and not root.right:
            res.append(s)
```

