

# 106. Construct Binary Tree from Inorder and Postorder Traversal

### 题目

链接：https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/



### 思路1 - Recursive

#### 步骤

- 由于先序的顺序的第一个肯定是根，所以知道二叉树的根节点
- 因为题目中的树没有相同元素，所以可以在inorder中定位出根节点的位置，从而将中序遍历拆分为左右两个部分
- 再去递归调用原函数
- 重点：递归postorder的index
  - inorder -> [left subtree] [root] [right subtree]
  - preorder -> [root] [left subtree] [right subtree]
  - postorder -> [left subtree] [right substree] [root]
  - 根据以上顺序去计算




#### 复杂度

时间：` O(N)`

空间：` O(N)` 



#### 代码

##### Java

```java
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if(il > ir || pl > pr) return null;
        int i = 0;
        for(i = il; i <= ir; i++) {
            if(postorder[pr] == inorder[i]) break;
        }
        TreeNode node = new TreeNode(postorder[pr]);
        node.left = build(inorder, il, i - 1, postorder, pl, pl + i - il - 1);
        node.right = build(inorder, i + 1, ir, postorder, pl + i - il, pr - 1);
        return node;
    }
}
```



##### Python

```python
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        return self.build(inorder, 0, len(inorder) - 1, postorder, 0, len(postorder) - 1)
    
    def build(self, inorder, il, ir, postorder, pl, pr):
        if pl > pr or il > ir:
            return
        i = 0
        for i in range(il, ir + 1):
            if inorder[i] == postorder[pr]:
                break;
        node = TreeNode(inorder[i])
        node.left = self.build(inorder, il, i - 1, postorder, pl, pl + i - 1 - il)
        node.right = self.build(inorder, i + 1, ir, postorder, pl + i - il, pr - 1)
        return node
```



### 思路2 - Iterative

#### 步骤

- TBC
- https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java

```



##### Python

```python

```

