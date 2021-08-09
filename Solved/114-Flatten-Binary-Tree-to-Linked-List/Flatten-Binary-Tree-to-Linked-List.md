

# 114. 

### 题目

链接：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/



### 思路1 - Recursive

#### 步骤

- 先利用 DFS 的思路找到最左子节点，然后回到其父节点，把其父节点和右子节点断开
- 将原左子结点连上父节点的右子节点上，然后再把原右子节点连到新右子节点的右子节点上
- 然后再回到上一父节点做相同操作




#### 复杂度

时间：` O(?)`

空间：` O(?)` 



#### 代码

##### Java

```java
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }
}
```



##### Python

```python
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return null
        if root.left:
            self.flatten(root.left)
        if root.right:
            self.flatten(root.right)
        tmp = root.right
        root.right = root.left
        root.left = None
        while root.right:
            root = root.right
        root.right = tmp
```



### 思路2 - Reverse Preorder Traversal 🌟

#### 步骤

- 因为题目要求按照preorder的顺序flatten treenode，逆着的顺序就是right - root - left
- 我们可以将每一个树节点的右指针按照上述顺序来赋值，并将左指针指向null
- 真的有点难理解欸：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36977/My-short-post-order-traversal-Java-solution-for-share

```
    1
   / \
  2   5
 / \   \
3   4   6
-----------        
pre = 5
cur = 4

    1
   / 
  2   
 / \   
3   4
     \
      5
       \
        6
-----------        
pre = 4
cur = 3

    1
   / 
  2   
 /   
3 
 \
  4
   \
    5
     \
      6
-----------        
cur = 2
pre = 3

    1
   / 
  2   
   \
    3 
     \
      4
       \
        5
         \
          6
-----------        
cur = 1
pre = 2

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```




#### 复杂度

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java
class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
```



##### Python

```python
class Solution:
    pre = None
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.flatten(root.right)
        self.flatten(root.left)
        root.right = self.pre
        root.left = None
        self.pre = root
```

