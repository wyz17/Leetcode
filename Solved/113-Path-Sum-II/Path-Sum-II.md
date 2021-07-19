

# 113. Path Sum II

### 题目

链接：https://leetcode.com/problems/path-sum-ii/



### 思路1 - Recursive

#### 步骤

- dfs递归




#### 复杂度

时间：` O(n!)`

空间：` O(n)` 



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, targetSum);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmpList, TreeNode root, int sum) {
        if(root == null) return;
        tmpList.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == sum) res.add(new ArrayList<Integer>(tmpList));
            else return;
        }
        if(root.left != null) {
            dfs(res, tmpList, root.left, sum - root.val);
            tmpList.remove(tmpList.size() - 1);
        }
        if(root.right != null) {
            dfs(res, tmpList, root.right, sum - root.val);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
```



##### Python

```python
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        res = []
        self.dfs(res, [], root, targetSum)
        return res
    
    def dfs(self, res, tmpList, root, num):
        if root:
            if not root.left and not root.right and num == root.val:
                tmpList.append(root.val)
                res.append(tmpList)
            self.dfs(res, tmpList + [root.val], root.left, num - root.val)
            self.dfs(res, tmpList + [root.val], root.right, num - root.val)
```



### 思路2 - Iterative

#### 步骤

- 用栈去实现dfs
- https://leetcode.com/problems/path-sum-ii/discuss/36695/Java-Solution%3A-iterative-and-recursive




#### 复杂度

时间：` O(n)`

空间：` O(n)`



#### 代码

##### Java

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        
        int sum = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        
        while(cur != null || !stk.isEmpty()) {
            // go down all the way to the left leaf node
            // add all the left nodes to the stack 
            while(cur != null) {
                stk.push(cur);
                path.add(cur.val);
                sum += cur.val;
                cur = cur.left;
            }
            cur = stk.peek();
            // check left leaf node's right subtree 
            // or check if it is not from the right subtree
            // why peek here? 
            // because if it has right subtree, we don't need to push it back
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
                // back to the outer while loop
                continue;
            }
            if(cur.left == null && cur.right == null && sum == targetSum) {
                res.add(new ArrayList<Integer>(path));
            }
            
            pre = cur;
            
            // pop out the current value
            stk.pop();
            path.remove(path.size() - 1);
            sum -= cur.val;
            cur = null;
        }
        return res;
    }
}
```



##### Python

```python
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        res = []
        path = []
        stk = []
        
        s = 0
        cur = root
        pre = None
        
        while cur or stk:
            while cur:
                stk.append(cur)
                path.append(cur.val)
                s += cur.val
                cur = cur.left
            cur = stk[-1]
            if cur.right and cur.right != pre:
                cur = cur.right
                continue
            if not cur.left and not cur.right and s == targetSum:
                res.append(path[:])
            pre = cur
            stk.pop()
            path.pop()
            s -= cur.val
            cur = None
        return res
```

