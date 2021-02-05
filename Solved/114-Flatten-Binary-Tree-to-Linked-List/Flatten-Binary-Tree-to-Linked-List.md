

# 114. Flatten Binary Tree to Linked List

### 题目

链接：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/



### 思路1 - Recursive

#### 步骤

- 




#### 复杂度

时间：` O(?)`

空间：` O(?)` 



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

- 用栈去做
- 有空补
- https://leetcode.com/problems/path-sum-ii/discuss/36695/Java-Solution%3A-iterative-and-recursive




#### 复杂度

时间：` O(?)`

空间：` O(?)`



#### 代码

##### Java

```java

```



##### Python

```python

```

