

# 130. Surrounded Regions

### 题目

链接：https://leetcode.com/problems/surrounded-regions/



### 思路 - DFS

#### 步骤

- 把矩阵边界连通的O全部找到，其余的O改为X
- 起始顶点为所有边界O的坐标
- flag\[i][j]标志O是否已经走过，若使用flag标记，则使用了O（m*n）的额外空间复杂度，所以把走过的标记为V
- 邻接点为上下左右且符合要求的O.



#### 复杂度

时间： `O(nh)`

空间：` O(h)`



#### 代码

##### Java

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int res) {
        if(root == null) return 0;
        if (root.right == null && root.left == null) return res * 10 + root.val;
        return sum(root.right, res * 10 + root.val) + sum(root.left, res * 10 + root.val);
    }
}
```



##### Python

```python
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        nums = []
        res = 0
        self.dfs(root, nums, 0)
        for num in nums:
            res += num
        return res
        
        
        
    def dfs(self, root, res, num):
        if not root:
            return
        # num = num + str(root.val)
        num = num * 10 + root.val
        if not root.left and not root.right:
            res.append(num)
        self.dfs(root.left, res, num)
        self.dfs(root.right, res, num)
 
# 优化2
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        return self.sum(root, 0)
    
    def sum(self, root, res):
        if not root:
            return 0
        if not root.left and not root.right:
            return res * 10 + root.val
        return self.sum(root.left, res * 10 + root.val) + self.sum(root.right, res * 10 + root.val)
```


