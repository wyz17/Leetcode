

# 105. Construct Binary Tree from Preorder and Inorder Traversal

### 题目

链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/



### 思路1 - Recursive

#### 步骤

- 由于先序的顺序的第一个肯定是根，所以知道二叉树的根节点
- 因为题目中的树没有相同元素，所以可以在inorder中定位出根节点的位置，从而将中序遍历拆分为左右两个部分
- 再去递归调用原函数
- 重点：递归preorder的index
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if(pl > pr || il > ir) return null;
        int i = 0;
        for(i = il; i <= ir; i++) {
            if(preorder[pl] == inorder[i]) break;
        }
        TreeNode node = new TreeNode(preorder[pl]);
        node.left = build(preorder, pl + 1, pl + i - il, inorder, il, i - 1);
        node.right = build(preorder, pl + i - il + 1, pr, inorder, i + 1, ir);
        return node;
    }
}
```



##### Python

```python
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        return self.build(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)
    
    def build(self, preorder, pl, pr, inorder, il, ir):
        if pl > pr or il > ir:
            return
        i = 0
        for i in range(il, ir + 1):
            if preorder[pl] == inorder[i]:
                break
        node = TreeNode(preorder[pl])
        node.left = self.build(preorder, pl + 1, pl + i - il, inorder, il, i - 1)
        node.right = self.build(preorder, pl + i - il + 1, pr, inorder, i + 1, ir)
        return node
```



### 思路2 - Iterative

#### 步骤

- TBC



参考链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map


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

