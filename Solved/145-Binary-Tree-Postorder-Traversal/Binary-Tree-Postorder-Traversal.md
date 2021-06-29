

# 144. Binary Tree Preorder Traversal

### 题目

链接：https://leetcode.com/problems/binary-tree-postorder-traversal/



### 思路1 - Recursive

#### 步骤

- 递归遍历，顺序 左 - 右 - 中

  


#### 复杂度

时间：` O(N)`

空间：` O(logN)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        post(res, root);
        return res;
    }
    
    private void post(List<Integer> res, TreeNode root) {
        if(root == null) return;
        post(res, root.left);
        post(res, root.right);
        res.add(root.val);
    }
}
```



##### Python

```python
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.post(res, root)
        return res
        
    def post(self, res, root):
        if root == None:
            return
        self.post(res, root.left)
        self.post(res, root.right)
        res.append(root.val)
```



### 思路2 - Stack

#### 步骤

- 栈先存入右边，再存入左边（栈是先进后出），再存入当前节点的值（加上pos 0），依次出栈就是后序遍历。



#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        
        while(!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(0, node.val);
            if(node.left != null) {
                stk.push(node.left);
            }
            if(node.right != null) {
                stk.push(node.right);
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        
        stk = []
        stk.append(root)
        while stk:
            node = stk.pop()
            res.insert(0, node.val)
            if node.left:
                stk.append(node.left)
            if node.right:
                stk.append(node.right)
        return res
```

