

# 94. Binary Tree Inorder Traversal

### 题目

链接：https://leetcode.com/problems/binary-tree-inorder-traversal/



### 思路1 - Recursive

#### 步骤

- 递归遍历节点的左子树，再存入当前节点，再遍历右子树

  


#### 复杂度

时间：` O(N)`

空间：` O(logN)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        in(res, root);
        return res;
    }
    
    private void in(List<Integer> res, TreeNode root) {
        if(root == null) return;
        in(res, root.left);
        res.add(root.val);
        in(res, root.right);
    }
}
```



##### Python

```python
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.inorder(res, root)
        return res
    
    def inorder(self, res, root):
        if root == None:
            return
        self.inorder(res, root.left)
        res.append(root.val)
        self.inorder(res, root.right)
```



### 思路2 - Stack

#### 步骤

- 栈依次存入左节点所有点，直到最左侧在栈顶。
- 开始抛出栈顶并访问。(例如第一个抛出2)。如果有右节点。那么将右节点加入栈中，然后右节点一致左下遍历直到尾部。（这里5和7没有左节点，所以不加）但是如果抛出15。右节点加入23.再找23的左侧节点加入栈顶。就这样循环下去直到栈为空。
- 可行性分析：中序是【左—中—右】的顺序。访问完左侧。当抛出当前点的时候说明左侧已经访问完(或者自己就是左侧)，那么需要首先访问当前点的右侧。那么这个右节点把它当成根节点重复相同操作（因为右节点要满足先左再右的顺序）。这样其实就是模拟了一个递归的过程，需要自己思考。





#### 复杂度

时间：` O(N)`

空间：` O(N)`



#### 代码

##### Java

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root != null) {
            if(root != null) {
                stk.push(root);
                root = root.left;
            } else {
                TreeNode cur = stk.pop();
                res.add(cur.val);
                root = cur.right;
            }
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        stk = []
        while stk or root:
            if root != None:
                stk.append(root)
                root = root.left
            else:
                cur = stk.pop()
                res.append(cur.val)
                root = cur.right
        return res
```

