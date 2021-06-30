# 173. Binary Search Tree Iterator

### 题目

- 链接：https://leetcode.com/problems/binary-search-tree-iterator/
- 题意：构造一个二叉搜索树迭代器，意思就是给你一个二叉树，然后将这个二叉树的值从小到大排序输出。本质上就是二叉树前序遍历的非递归版本



### 思路

#### 步骤

- 用stack来存储，初始化时只存根节点的左节点
- 当next函数被调用的时候，出栈一个节点，然后并将他的右节点当作新的根节点



#### 复杂度

时间： `O(V + E)`

空间：` O(V + E)`



#### 代码

##### Java

```java
class BSTIterator {
    private TreeNode visit;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        visit =  root;
        stack = new Stack();
    }
    
    public int next() {
        while(visit != null) {
            stack.push(visit);
            visit = visit.left;
        }
        TreeNode next = stack.pop();
        visit = next.right;
        return next.val;
    }
    
    public boolean hasNext() {
        return visit != null || !stack.empty();
    }
}
```



##### Python

```python
class BSTIterator:
    def __init__(self, root: TreeNode):
        self.visit = root
        self.stk = []
        

    def next(self) -> int:
        while self.visit:
            self.stk.append(self.visit)
            self.visit = self.visit.left
        next = self.stk.pop()
        self.visit = next.right
        return next.val
        

    def hasNext(self) -> bool:
        return self.visit is not None or len(self.stk) != 0
```

