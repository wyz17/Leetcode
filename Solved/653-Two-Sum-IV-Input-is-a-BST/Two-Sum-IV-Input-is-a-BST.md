# 653. Two Sum IV - Input is a BST

### 题目

链接：https://leetcode.com/problems/two-sum-iv-input-is-a-bst/



### 思路

#### 步骤

- 递归遍历每一个节点
- 同时用hashset存入数值



#### 复杂度

时间： `O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return helper(root, set, k);
        
    }
    
    private boolean helper(TreeNode node, Set<Integer> set, int k)  {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return helper(node.left, set, k) || helper(node.right, set, k);
    }
}
```



##### Python

```python
class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        s = set()
        return self.helper(root, s, k)
    
    def helper(self, node, s, k):
        if node == None:
            return False
        if k - node.val in s:
            return True
        s.add(node.val);
        return self.helper(node.left, s, k) or self.helper(node.right, s, k);
```

