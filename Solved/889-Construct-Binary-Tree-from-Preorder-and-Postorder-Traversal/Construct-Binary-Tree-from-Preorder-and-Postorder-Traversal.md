

# 889. Construct Binary Tree from Preorder and Postorder Traversal

### 题目

链接：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/



### 思路1 - Recursive

#### 步骤

- 递归开始：找到根节点```pre[preIndex]```
- 递归结束：因为在后序遍历中，根节点是最后一个，所以当`root.val == post[posIndex]`时，我们就构造出了整个树
- 递归中：分别调用初始函数来分别构造左子树和右子树
- 画图分析一下，这个方法太绝了！
- 重点：递归遍历的index
  - inorder -> [left subtree] [root] [right subtree]
  - preorder -> [root] [left subtree] [right subtree]
  - postorder -> [left subtree] [right substree] [root]
  - 根据以上顺序去计算




#### 复杂度

时间：` O(N)`

空间：` O(height)` ，取决于树的高度



#### 代码

##### Java

```java
class Solution {
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if(root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if(root.val != post[postIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        postIndex++;
        return root;
    }
}
```



##### Python

```python
class Solution:
    preIndex = 0
    postIndex = 0
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        root = TreeNode(pre[self.preIndex])
        self.preIndex += 1
        if root.val != post[self.postIndex]:
            root.left = self.constructFromPrePost(pre, post)
        if root.val != post[self.postIndex]:
            root.right = self.constructFromPrePost(pre, post)
        self.postIndex += 1
        return root
```



### 思路2 - Iterative

#### 步骤

- 用preorder生成TreeNode
- 一个个用栈保存
- 根据postorder的顺序出栈
- `node = new TreeNode(pre[i])`，如果没有左子树，就将这个节点加在左边；否则加在右边
- 如果在当前遍历时pre和post是一样的值，说明它对应的子树已经构造完成了，所以对于当前值就出栈




#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        int j = 0;
        for (int i = 1; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast(); j++;
            }
            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }
}
```



##### Python

```python
class Solution:
    preIndex = 0
    postIndex = 0
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        stack = [TreeNode(pre[0])]
        j = 0
        for v in pre[1:]:
            node = TreeNode(v)
            while stack[-1].val == post[j]:
                stack.pop()
                j += 1
            if not stack[-1].left:
                stack[-1].left = node
            else:
                stack[-1].right = node
            stack.append(node)
        return stack[0]
```

