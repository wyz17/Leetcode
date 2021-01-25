

# 100. Same Tree

### 题目

链接：https://leetcode.com/problems/same-tree/



### 思路1 - Recursive

#### 步骤

- 傻瓜解法，看代码就好啦




#### 复杂度

时间：` O(N)`

空间：` O(logN)`



#### 代码

##### Java

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```



##### Python

```python
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
```



### 思路2 - Iterative 

太麻烦略过！complexity和recursive是一样哒！