

# 144. Binary Tree Preorder Traversal

### 题目

链接：https://leetcode.com/problems/binary-tree-preorder-traversal/



### 思路1 - Recursive

#### 步骤

- 递归遍历，顺序中 - 左 - 右

  


#### 复杂度

时间：` O(N)`

空间：` O(logN)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(res, root);
        return res;
    }
    
    private void pre(List<Integer> res, TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        pre(res, root.left);
        pre(res, root.right);
    }
}
```



##### Python

```python
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.pre(res, root)
        return res
    
    def pre(self, res, root):
        if root == None:
            return
        res.append(root.val)
        self.pre(res, root.left)
        self.pre(res, root.right)
```



### 思路2 - Stack

#### 步骤

- 栈先存入当前节点，再存入右边，再存入左边（栈是先进后出），依次出栈就是前序遍历。



#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        
        while(!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right != null) {
                stk.push(node.right);
            }
            if(node.left != null) {
                stk.push(node.left);
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        
        stk = []
        stk.append(root)
        while stk:
            node = stk.pop()
            res.append(node.val)
            if node.right:
                stk.append(node.right)
            if node.left:
                stk.append(node.left)
        return res
```

