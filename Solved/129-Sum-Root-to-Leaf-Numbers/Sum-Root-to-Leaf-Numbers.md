

# 129. Sum Root to Leaf Numbers

### 题目

链接：https://leetcode.com/problems/sum-root-to-leaf-numbers/



### 思路 - Recursive

#### 步骤

- dfs遍历二叉树，获取path的列表
- 遍历列表，在将列表中的字符串转为数字相加 
  - 优化1：直接用 num * 10 + root.val 就好，不需要字符串处理
  - 优化2：不需要返回列表，直接返回int



#### 复杂度

时间： `O(nh)`, where `n` is number of nodes and `h` is number of levels, because at each step our numbers become bigger and bigger. 

空间：` O(h)`, keep the stack of recursion.



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


